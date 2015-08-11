package org.arena.ui;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.xml.transform.Result;

import org.arena.datamodel.MatchType;
import org.arena.datamodel.Speciality;
import org.arena.datamodel.Strategy;
import org.arena.lang.LocalText;

public class ArenaWindow {
  private final static String FRAME_NAME = "ArenaStats";
  private static final int FRAME_WIDTH = 760;
  private static final int FRAME_HEIGHT = 700;
  private static final Dimension BUTTON_PREF_DIM = new Dimension(70, 25);
  private static final Dimension TEXT_FIELD_PREF_DIM = new Dimension(70, 25); 
  private static final Dimension COMBO_PREF_DIM = new Dimension(90, 25); 
  //private final static int MAX_PLAYERS = 5;   // Max players in one team
  
  private LocalText localLang;
  private Speciality[] specs;
  
  private JFrame wholeFrame;
  
  private JTabbedPane tabPanel;
  private JPanel addPanel;
  private JPanel statPanel;
  private JPanel topAddPanel;
  private JPanel playersPanel;
  private JPanel bottomAddPanel;
  private JScrollPane playersWrapper;
  
  private JComboBox<MatchType> matchesBox;
  private JComboBox<Strategy> strategiesBox;
  private JComboBox<Result> resultBox;
  private List<JComboBox<Speciality>> playersBoxes;
  private List<JComboBox<Speciality>> enemiesBoxes;
  
  private JTextField dateField;
  private JTextField dbMergeField;
  private List<JTextField> playerNamesFields;
  
  private JLabel matchTypeLabel;
  private JLabel globPlayersLabel;
  private JLabel globEnemiesLabel;
  private JLabel stratLabel;
  private JLabel resultLabel;
  private JLabel dateLabel;
  private JLabel mergeLabel;
  private List<JLabel> playersDefLabels;
  private List<JLabel> enemiesDefLabels;
  
  private JButton confirmDataButton;
  private JButton mergeButton;
  
  private JSeparator playerSeparator;
  private JSeparator dbSeparator;
  
  public ArenaWindow(LocalText lang, MatchType[] modes, Strategy[] strats, Result[] results, Speciality[] specialities) {
    this.localLang = lang;
    this.specs = specialities;
    
    this.tabPanel = new JTabbedPane();
    this.addPanel = new JPanel();
    this.statPanel = new JPanel();
    this.topAddPanel = new JPanel();
    this.playersPanel = new JPanel();
    this.bottomAddPanel = new JPanel();
    
    this.matchesBox = new JComboBox<>(modes);
    this.strategiesBox = new JComboBox<>(strats);
    this.resultBox = new JComboBox<>(results);
    this.playersBoxes = new ArrayList<>();
    this.enemiesBoxes = new ArrayList<>();
    
    this.dateField = new JTextField();
    this.dbMergeField = new JTextField();
    this.playerNamesFields = new ArrayList<>();
    
    this.matchTypeLabel = new JLabel(lang.getMatchType());
    this.globPlayersLabel = new JLabel(lang.getPlayers());
    this.globEnemiesLabel = new JLabel(lang.getEnemies());
    this.stratLabel = new JLabel(lang.getStrat());
    this.resultLabel = new JLabel(lang.getResult());
    this.dateLabel = new JLabel(lang.getDate());
    this.mergeLabel = new JLabel(lang.getDbMerge());
    this.playersDefLabels = new ArrayList<>();
    this.enemiesDefLabels = new ArrayList<>();
    
    this.confirmDataButton = new JButton();
    this.mergeButton = new JButton();
    
    this.playerSeparator = new JSeparator(SwingConstants.VERTICAL);
    this.dbSeparator = new JSeparator(SwingConstants.HORIZONTAL);
  }
  
  public void initComponents(ActionListener addListener, ActionListener mergeListener) {
    
    this.topAddPanel.setLayout(new BoxLayout(this.topAddPanel, BoxLayout.X_AXIS));
    this.topAddPanel.add(matchTypeLabel);
    this.topAddPanel.add(this.matchesBox);
    this.matchesBox.setSelectedIndex(0);
    this.matchesBox.setPreferredSize(COMBO_PREF_DIM);
    updatePlayersPanel();
    buildBottomPanel();
    
    this.addPanel.setLayout(new BoxLayout(this.addPanel, BoxLayout.Y_AXIS));
    this.addPanel.add(this.topAddPanel);
    this.addPanel.add(this.playersWrapper);
    this.addPanel.add(this.bottomAddPanel);
    this.tabPanel.addTab(this.localLang.getAddData(), this.addPanel);
    
    this.mergeButton.addActionListener(mergeListener);
    this.confirmDataButton.addActionListener(addListener);
    
    this.wholeFrame = new JFrame(FRAME_NAME);
    this.wholeFrame.setSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
    this.wholeFrame.setResizable(false);
    this.wholeFrame.setLocationRelativeTo(null);  
    this.wholeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.wholeFrame.add(this.tabPanel);
    this.wholeFrame.setVisible(true);
  }
  
  private void updatePlayersPanel() {
    this.playersDefLabels = new ArrayList<>();
    this.playersBoxes = new ArrayList<>();
    this.playerNamesFields = new ArrayList<>();
    this.enemiesBoxes = new ArrayList<>();
    this.enemiesDefLabels = new ArrayList<>();
    
    this.playersPanel = new JPanel();
    this.playersPanel.setLayout(new GridBagLayout());
    this.playersPanel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
    GridBagConstraints constraints = new GridBagConstraints();
    int playerNumber = ((MatchType)this.matchesBox.getSelectedItem()).getPlayerNumber();
    
    constraints.gridx = 0;
    constraints.gridy = 0;
    constraints.weightx = 1;
    constraints.weighty = 1;
    constraints.gridwidth = 3;
    constraints.anchor = GridBagConstraints.LINE_START;
    playersPanel.add(this.globPlayersLabel, constraints);
    
    constraints.gridx = 3;
    constraints.gridy = 0;
    constraints.weightx = 0.1;
    constraints.weighty = 0.1;
    constraints.gridwidth = 1;
    constraints.gridheight = playerNumber + 1;
    constraints.anchor = GridBagConstraints.CENTER;
    playersPanel.add(this.playerSeparator, constraints);
    
    constraints.gridx = 4;
    constraints.gridy = 0;
    constraints.weightx = 0.8;
    constraints.weighty = 0.8;
    constraints.gridwidth = 2;
    constraints.gridheight = 1;
    constraints.anchor = GridBagConstraints.LINE_START;
    playersPanel.add(this.globEnemiesLabel, constraints);
    
    for (int i = 0 ; i < playerNumber ; i++) {
      JLabel playerLabel = new JLabel(this.localLang.getName());
      JLabel enemyLabel = new JLabel(this.localLang.getEnemy(i));
      JTextField playerField = new JTextField();
      JComboBox<Speciality> playerBox = new JComboBox<>(this.specs);
      JComboBox<Speciality> enemyBox = new JComboBox<>(this.specs);
      
      playerField.setPreferredSize(TEXT_FIELD_PREF_DIM);
      playerBox.setPreferredSize(COMBO_PREF_DIM);
      enemyBox.setPreferredSize(COMBO_PREF_DIM);
      
      this.playersDefLabels.add(playerLabel);
      this.playersBoxes.add(playerBox);
      this.playerNamesFields.add(playerField);
      this.enemiesBoxes.add(enemyBox);
      this.enemiesDefLabels.add(enemyLabel);
      
      constraints.gridx = 0;
      constraints.gridy = i + 1;
      constraints.weightx = 0.1;
      constraints.weighty = 0.1;
      constraints.gridwidth = 1;
      constraints.anchor = GridBagConstraints.LINE_START;
      playersPanel.add(playerLabel, constraints);
      
      constraints.gridx = 1;
      constraints.gridy = i + 1;
      constraints.weightx = 0.1;
      constraints.weighty = 0.1;
      constraints.anchor = GridBagConstraints.LINE_START;
      playersPanel.add(playerField, constraints);
      
      constraints.gridx = 2;
      constraints.gridy = i + 1;
      constraints.weightx = 0.8;
      constraints.weighty = 0.8;
      constraints.anchor = GridBagConstraints.LINE_START;
      playersPanel.add(playerBox, constraints);
      
      constraints.gridx = 4;
      constraints.gridy = i + 1;
      constraints.weightx = 0.1;
      constraints.weighty = 0.1;
      constraints.anchor = GridBagConstraints.LINE_START;
      playersPanel.add(enemyLabel, constraints);
      
      constraints.gridx = 5;
      constraints.gridy = i + 1;
      constraints.weightx = 0.1;
      constraints.weighty = 0.1;
      constraints.anchor = GridBagConstraints.LINE_START;
      playersPanel.add(enemyBox, constraints);
      
    }
    
    this.playersWrapper = new JScrollPane(this.playersPanel);
  }
  
  private void buildBottomPanel() {
    this.confirmDataButton.setText(this.localLang.getDataConfirm());
    this.mergeButton.setText(this.localLang.getMergeConfirm());
    this.confirmDataButton.setPreferredSize(BUTTON_PREF_DIM);
    this.mergeButton.setPreferredSize(BUTTON_PREF_DIM);
    this.dateField.setPreferredSize(TEXT_FIELD_PREF_DIM);
    
    this.bottomAddPanel.setLayout(new GridBagLayout());
    this.bottomAddPanel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
    GridBagConstraints constraints = new GridBagConstraints();
    
    constraints.gridx = 0;
    constraints.gridy = 0;
    constraints.weightx = 0.1;
    constraints.weighty = 1;
    constraints.anchor = GridBagConstraints.LINE_START;
    bottomAddPanel.add(this.stratLabel, constraints);
    
    constraints.gridx = 1;
    constraints.gridy = 0;
    constraints.weightx = 0.7;
    constraints.anchor = GridBagConstraints.LINE_START;
    bottomAddPanel.add(this.strategiesBox, constraints);
    
    constraints.gridx = 3;
    constraints.gridy = 0;
    constraints.weightx = 0.3;
    constraints.anchor = GridBagConstraints.LINE_END;
    bottomAddPanel.add(this.confirmDataButton, constraints);
    
    constraints.gridx = 0;
    constraints.gridy = 1;
    constraints.weightx = 0.1;
    constraints.anchor = GridBagConstraints.LINE_START;
    bottomAddPanel.add(this.resultLabel, constraints);
    
    constraints.gridx = 1;
    constraints.gridy = 1;
    constraints.weightx = 0.7;
    constraints.anchor = GridBagConstraints.LINE_START;
    bottomAddPanel.add(this.resultBox, constraints);
    
    constraints.gridx = 0;
    constraints.gridy = 2;
    constraints.weightx = 0.1;
    constraints.anchor = GridBagConstraints.LINE_START;
    bottomAddPanel.add(this.dateLabel, constraints);
    
    constraints.gridx = 1;
    constraints.gridy = 2;
    constraints.weightx = 0.7;
    constraints.anchor = GridBagConstraints.LINE_START;
    bottomAddPanel.add(this.dateField, constraints);
    
    constraints.gridx = 0;
    constraints.gridy = 3;
    constraints.weightx = 1;
    constraints.weighty = 0.1;
    constraints.gridwidth = 4;
    constraints.anchor = GridBagConstraints.CENTER;
    bottomAddPanel.add(this.dbSeparator, constraints);
    
    constraints.gridx = 0;
    constraints.gridy = 4;
    constraints.weightx = 0.8;
    constraints.weighty = 1;
    constraints.gridwidth = 2;
    constraints.anchor = GridBagConstraints.LINE_START;
    bottomAddPanel.add(this.mergeLabel, constraints);
    
    constraints.gridx = 2;
    constraints.gridy = 4;
    constraints.weightx = 0.5;
    constraints.gridwidth = 1;
    constraints.anchor = GridBagConstraints.LINE_START;
    bottomAddPanel.add(this.dbMergeField, constraints);
    
    constraints.gridx = 3;
    constraints.gridy = 4;
    constraints.weightx = 0.3;
    constraints.anchor = GridBagConstraints.LINE_END;
    bottomAddPanel.add(this.mergeButton, constraints);
  }
}

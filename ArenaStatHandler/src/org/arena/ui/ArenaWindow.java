package org.arena.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;

import org.arena.datamodel.MatchResult;
import org.arena.datamodel.MatchType;
import org.arena.datamodel.Speciality;
import org.arena.datamodel.Strategy;
import org.arena.lang.LocalText;

public class ArenaWindow {
  private final static String FRAME_NAME = "ArenaStats";
  private static final int FRAME_WIDTH = 760;
  private static final int FRAME_HEIGHT = 700;
  
  private static final int HORIZONTAL_GAP = 7;
  private static final int VERTICAL_GAP = 5;
  
  private static final Dimension BUTTON_PREF_DIM = new Dimension(100, 25);
  
  private static final Dimension TEXT_FIELD_MIN_DIM = new Dimension(70, 25); 
  private static final Dimension TEXT_FIELD_PREF_DIM = new Dimension(80, 25); 
  private static final Dimension TEXT_FIELD_MAX_DIM = new Dimension(90, 25); 
  
  private static final Dimension LONG_TEXT_MIN_DIM = new Dimension(130, 25);
  private static final Dimension LONG_TEXT_PREF_DIM = new Dimension(140, 25);
  private static final Dimension LONG_TEXT_MAX_DIM = new Dimension(150, 25);
  
  private static final Dimension COMBO_MIN_DIM = new Dimension(160, 25);
  private static final Dimension COMBO_PREF_DIM = new Dimension(180, 25);
  private static final Dimension COMBO_MAX_DIM = new Dimension(200, 25);
  
  private static final Dimension TYPE_FILLER = new Dimension(FRAME_WIDTH * 2/3, 25);
  
  private static final Dimension TOP_PREF_DIM = new Dimension(FRAME_WIDTH, FRAME_HEIGHT/20);
  //private static final Dimension MIDDLE_PREF_DIM = new Dimension(FRAME_WIDTH, FRAME_HEIGHT/6);
  private static final Dimension BOTTOM_PREF_DIM = new Dimension(FRAME_WIDTH, FRAME_HEIGHT/4);
  
  private static final String LABEL_FOLLOW = ": ";
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
  private JComboBox<MatchResult> resultBox;
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
  
  private BoxLayout addPanelLayout;
  private GroupLayout playersLayout;
  
  public ArenaWindow(LocalText lang, MatchType[] modes, Strategy[] strats, MatchResult[] results, Speciality[] specialities) {
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
    
    this.matchTypeLabel = new JLabel(lang.getMatchType() + LABEL_FOLLOW);
    this.globPlayersLabel = new JLabel(lang.getPlayers() + LABEL_FOLLOW);
    this.globEnemiesLabel = new JLabel(lang.getEnemies() + LABEL_FOLLOW);
    this.stratLabel = new JLabel(lang.getStrat() + LABEL_FOLLOW);
    this.resultLabel = new JLabel(lang.getResult() + LABEL_FOLLOW);
    this.dateLabel = new JLabel(lang.getDate() + LABEL_FOLLOW);
    this.mergeLabel = new JLabel(lang.getDbMerge() + LABEL_FOLLOW);
    this.playersDefLabels = new ArrayList<>();
    this.enemiesDefLabels = new ArrayList<>();
    
    this.confirmDataButton = new JButton();
    this.mergeButton = new JButton();
    
    this.playerSeparator = new JSeparator(SwingConstants.VERTICAL);
    this.dbSeparator = new JSeparator(SwingConstants.HORIZONTAL);
  }
  
  public void initComponents(ActionListener mergeListener, ActionListener addListener) {
    this.matchesBox.addActionListener(e -> windowUpdate());
    
    this.playerSeparator.setPreferredSize(new Dimension(1, 0));
    this.dbSeparator.setPreferredSize(new Dimension(FRAME_WIDTH, 1));
    
    this.dateField.setMinimumSize(TEXT_FIELD_MIN_DIM);
    this.dbMergeField.setMinimumSize(LONG_TEXT_MIN_DIM);
    this.resultBox.setMinimumSize(COMBO_MIN_DIM);
    this.strategiesBox.setMinimumSize(COMBO_MIN_DIM);
    this.matchesBox.setMinimumSize(COMBO_MIN_DIM);
    
    this.dateField.setPreferredSize(TEXT_FIELD_PREF_DIM);
    this.dbMergeField.setPreferredSize(LONG_TEXT_PREF_DIM);
    this.resultBox.setPreferredSize(COMBO_PREF_DIM);
    this.strategiesBox.setPreferredSize(COMBO_PREF_DIM);
    this.matchesBox.setPreferredSize(COMBO_PREF_DIM);
    
    this.confirmDataButton.setMaximumSize(BUTTON_PREF_DIM);
    this.mergeButton.setMaximumSize(BUTTON_PREF_DIM);
    this.dateField.setMaximumSize(TEXT_FIELD_MAX_DIM);
    this.dbMergeField.setMaximumSize(LONG_TEXT_MAX_DIM);
    this.resultBox.setMaximumSize(COMBO_MAX_DIM);
    this.strategiesBox.setMaximumSize(COMBO_MAX_DIM);
    this.matchesBox.setMaximumSize(COMBO_MAX_DIM);
    
    this.topAddPanel.setLayout(new BoxLayout(this.topAddPanel, BoxLayout.X_AXIS));
    this.topAddPanel.add(Box.createHorizontalStrut(10));
    this.topAddPanel.add(matchTypeLabel);
    this.topAddPanel.add(Box.createHorizontalStrut(10));
    this.topAddPanel.add(this.matchesBox);
    this.topAddPanel.add(Box.createRigidArea(TYPE_FILLER));
    this.topAddPanel.add(Box.createHorizontalGlue());
    
    updatePlayersPanel();
    buildBottomPanel();
    
    /*
    this.topAddPanel.setPreferredSize(TOP_PREF_DIM);
    this.playersWrapper.setPreferredSize(MIDDLE_PREF_DIM);
    this.bottomAddPanel.setPreferredSize(BOTTOM_PREF_DIM);
    */
    this.topAddPanel.setMaximumSize(TOP_PREF_DIM);
    //this.playersWrapper.setMaximumSize(MIDDLE_PREF_DIM);
    this.bottomAddPanel.setMaximumSize(BOTTOM_PREF_DIM);
    
    this.addPanelLayout = new BoxLayout(this.addPanel, BoxLayout.Y_AXIS);
    this.addPanel.setLayout(addPanelLayout);
    this.addPanel.add(Box.createVerticalStrut(VERTICAL_GAP));
    this.addPanel.add(this.topAddPanel);
    this.addPanel.add(Box.createVerticalStrut(VERTICAL_GAP));
    this.addPanel.add(this.playersWrapper);
    this.addPanel.add(this.bottomAddPanel);
    //this.addPanel.add(Box.createRigidArea(new Dimension(FRAME_WIDTH, FRAME_HEIGHT/3)));
    
    this.tabPanel.addTab(this.localLang.getAddData(), this.addPanel);
    this.tabPanel.setBackground(Color.WHITE);
    
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
  
  public String getDbField() {
    return this.dbMergeField.getText();
  }

  public Speciality[] getEnemies() {
    Object[] objArray = this.enemiesBoxes.stream().map(box -> box.getSelectedItem()).toArray();
    Speciality[] specArray = new Speciality[objArray.length];
    for (int i = 0 ; i < objArray.length ; i++) {
      specArray[i] = (Speciality) objArray[i];
    }
    return specArray; 
  }
  
  public Speciality[] getPlayerSpec() {
    Object[] objArray = this.playersBoxes.stream().map(box -> box.getSelectedItem()).toArray();
    Speciality[] specArray = new Speciality[objArray.length];
    for (int i = 0 ; i < objArray.length ; i++) {
      specArray[i] = (Speciality) objArray[i];
    }
    return specArray; 
  }
  
  public String[] getPlayerNames() {
    //return (String[]) this.playerNamesFields.stream().peek(box -> box.getText()).toArray();
    Object[] objArray = this.playerNamesFields.stream().map(box -> box.getText()).toArray();
    String[] specArray = new String[objArray.length];
    for (int i = 0 ; i < objArray.length ; i++) {
      specArray[i] = (String) objArray[i];
    }
    return specArray; 
  }
  
  public MatchType getMatchType() {
    return (MatchType) this.matchesBox.getSelectedItem();
  }
  
  public MatchResult getMatchResult() {
    return (MatchResult) this.resultBox.getSelectedItem();
  }
  
  public Strategy getStrategy() {
    return (Strategy) this.strategiesBox.getSelectedItem();
  }
  
  public String getDate() {
    return this.dateField.getText();
  }
  
  private void updatePlayersPanel() {
    this.playersDefLabels = new ArrayList<>();
    this.playersBoxes = new ArrayList<>();
    this.playerNamesFields = new ArrayList<>();
    this.enemiesBoxes = new ArrayList<>();
    this.enemiesDefLabels = new ArrayList<>();
    int playerNumber = ((MatchType)this.matchesBox.getSelectedItem()).getPlayerNumber();

    this.playersLayout = new GroupLayout(this.playersPanel);
    this.playersPanel.setLayout(this.playersLayout);
    
    SequentialGroup playersVGroup = playersLayout.createSequentialGroup();
    ParallelGroup playersHGroup = playersLayout.createParallelGroup(Alignment.CENTER);
    SequentialGroup enemiesVGroup = playersLayout.createSequentialGroup();
    ParallelGroup enemiesHGroup = playersLayout.createParallelGroup(Alignment.CENTER);
    
    playersHGroup.addGroup(playersLayout.createSequentialGroup()
        .addContainerGap()
        .addComponent(this.globPlayersLabel)
        .addGap(HORIZONTAL_GAP));
    
    playersVGroup.addGap(VERTICAL_GAP, VERTICAL_GAP, VERTICAL_GAP);
    playersVGroup.addGroup(playersLayout.createParallelGroup(Alignment.CENTER)
        .addComponent(this.globPlayersLabel)).addGap(VERTICAL_GAP, VERTICAL_GAP, VERTICAL_GAP);
    
    enemiesHGroup.addGroup(playersLayout.createSequentialGroup()
        .addGap(HORIZONTAL_GAP)
        .addComponent(this.globEnemiesLabel)
        .addContainerGap());
    
    enemiesVGroup.addGap(VERTICAL_GAP, VERTICAL_GAP, VERTICAL_GAP);
    enemiesVGroup.addGroup(playersLayout.createParallelGroup(Alignment.CENTER)
        .addComponent(this.globEnemiesLabel)).addGap(VERTICAL_GAP, VERTICAL_GAP, VERTICAL_GAP);
    
    for (int i = 0 ; i < playerNumber ; i++) {
      JLabel playerLabel = new JLabel(this.localLang.getName() + LABEL_FOLLOW);
      JLabel enemyLabel = new JLabel(this.localLang.getEnemy(i) + LABEL_FOLLOW);
      JTextField playerField = new JTextField();
      JComboBox<Speciality> playerBox = new JComboBox<>(this.specs);
      JComboBox<Speciality> enemyBox = new JComboBox<>(this.specs);
      
      playerField.setMinimumSize(TEXT_FIELD_MIN_DIM);
      playerBox.setMinimumSize(COMBO_MIN_DIM);
      enemyBox.setMinimumSize(COMBO_MIN_DIM);
      
      playerField.setPreferredSize(TEXT_FIELD_PREF_DIM);
      playerBox.setPreferredSize(COMBO_PREF_DIM);
      enemyBox.setPreferredSize(COMBO_PREF_DIM);
      
      playerField.setMaximumSize(TEXT_FIELD_MAX_DIM);
      playerBox.setMaximumSize(COMBO_MAX_DIM);
      enemyBox.setMaximumSize(COMBO_MAX_DIM);
      
      this.playersDefLabels.add(playerLabel);
      this.playersBoxes.add(playerBox);
      this.playerNamesFields.add(playerField);
      this.enemiesBoxes.add(enemyBox);
      this.enemiesDefLabels.add(enemyLabel);
      
      playersHGroup.addGroup(playersLayout.createSequentialGroup()
          .addContainerGap()
          .addComponent(playerLabel)
          .addGap(HORIZONTAL_GAP)
          .addComponent(playerField)
          .addGap(HORIZONTAL_GAP)
          .addComponent(playerBox)
          .addGap(HORIZONTAL_GAP));
      
      playersVGroup.addGroup(playersLayout.createParallelGroup(Alignment.CENTER)
          .addComponent(playerLabel)
          .addComponent(playerField)
          .addGap(VERTICAL_GAP, VERTICAL_GAP, VERTICAL_GAP)
          .addComponent(playerBox)).addGap(VERTICAL_GAP, VERTICAL_GAP, VERTICAL_GAP);
      
      enemiesHGroup.addGroup(playersLayout.createSequentialGroup()
          .addGap(HORIZONTAL_GAP)
          .addComponent(enemyLabel)
          .addGap(HORIZONTAL_GAP)
          .addComponent(enemyBox)
          .addContainerGap());
      
      enemiesVGroup.addGroup(playersLayout.createParallelGroup(Alignment.CENTER)
          .addComponent(enemyLabel)
          .addComponent(enemyBox)).addGap(VERTICAL_GAP, VERTICAL_GAP, VERTICAL_GAP);    
    }
    
    playersLayout.setHorizontalGroup(playersLayout.createSequentialGroup()
        .addGroup(playersHGroup)
        .addGroup(playersLayout.createParallelGroup())
          //.addComponent(this.playerSeparator))
        .addGroup(enemiesHGroup));
    
    playersLayout.setVerticalGroup(playersLayout.createParallelGroup()
        .addGroup(playersVGroup)
        .addGroup(playersLayout.createSequentialGroup()
          .addContainerGap()
          //.addComponent(this.playerSeparator)
          .addContainerGap())
        .addGroup(enemiesVGroup));
    
    this.playersWrapper = new JScrollPane(this.playersPanel);
  }
  
  private void buildBottomPanel() {
    this.confirmDataButton.setText(this.localLang.getDataConfirm());
    this.mergeButton.setText(this.localLang.getMergeConfirm());
    
    GroupLayout bottomLayout = new GroupLayout(this.bottomAddPanel);
    this.bottomAddPanel.setLayout(bottomLayout);
    this.bottomAddPanel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));

    bottomLayout.setHorizontalGroup(bottomLayout.createParallelGroup()
        .addGroup(bottomLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(this.stratLabel)
            .addGap(HORIZONTAL_GAP)
            .addComponent(this.strategiesBox)
            .addContainerGap())
        .addGroup(bottomLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(this.resultLabel)
            .addGap(HORIZONTAL_GAP)
            .addComponent(this.resultBox)
            .addContainerGap())
        .addGroup(bottomLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(this.dateLabel)
            .addGap(HORIZONTAL_GAP)
            .addComponent(this.dateField)
            //.addGap(HORIZONTAL_GAP)
            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, FRAME_WIDTH, FRAME_WIDTH)
            .addComponent(this.confirmDataButton)
            .addContainerGap())
        .addGroup(bottomLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(this.dbSeparator)
            .addContainerGap())
        .addGroup(bottomLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(this.mergeLabel)
            .addGap(HORIZONTAL_GAP)
            .addComponent(this.dbMergeField)
            //.addGap(HORIZONTAL_GAP)
            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, FRAME_WIDTH, FRAME_WIDTH)
            .addComponent(this.mergeButton)
            .addContainerGap()));
    
    bottomLayout.setVerticalGroup(bottomLayout.createSequentialGroup()
        .addContainerGap()
        .addGroup(bottomLayout.createParallelGroup(Alignment.CENTER)
            .addComponent(this.stratLabel)
            .addComponent(this.strategiesBox))
        .addGap(VERTICAL_GAP, VERTICAL_GAP, VERTICAL_GAP)
        .addGroup(bottomLayout.createParallelGroup(Alignment.CENTER)
            .addComponent(this.resultLabel)
            .addComponent(this.resultBox))
        .addGap(VERTICAL_GAP, VERTICAL_GAP, VERTICAL_GAP)
        .addGroup(bottomLayout.createParallelGroup(Alignment.CENTER)
            .addComponent(this.dateLabel)
            .addComponent(this.dateField)
            .addComponent(this.confirmDataButton))
        .addGap(VERTICAL_GAP, VERTICAL_GAP, VERTICAL_GAP)
        .addComponent(this.dbSeparator)
        .addGap(VERTICAL_GAP, VERTICAL_GAP, VERTICAL_GAP)
        .addGroup(bottomLayout.createParallelGroup(Alignment.CENTER)
            .addComponent(this.mergeLabel)
            .addComponent(this.dbMergeField)
            .addComponent(this.mergeButton))
        .addContainerGap());
  }
  
  
  //TODO: do better
  private void windowUpdate() {
    this.playersPanel = new JPanel();
    this.addPanel = new JPanel();
    
    updatePlayersPanel();
    
    this.addPanelLayout = new BoxLayout(this.addPanel, BoxLayout.Y_AXIS);
    this.addPanel.setLayout(addPanelLayout);
    this.addPanel.add(Box.createVerticalStrut(VERTICAL_GAP));
    this.addPanel.add(this.topAddPanel);
    this.addPanel.add(Box.createVerticalStrut(VERTICAL_GAP));
    this.addPanel.add(this.playersWrapper);
    this.addPanel.add(this.bottomAddPanel);
   
    this.tabPanel.removeTabAt(this.tabPanel.getSelectedIndex());
    this.tabPanel.insertTab(this.localLang.getAddData(), null, this.addPanel, "", 0);
    this.tabPanel.setBackground(Color.WHITE);
  }
}

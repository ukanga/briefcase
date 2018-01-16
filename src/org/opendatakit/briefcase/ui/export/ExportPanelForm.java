package org.opendatakit.briefcase.ui.export;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import org.opendatakit.briefcase.ui.export.components.ConfigurationPanel;
import org.opendatakit.briefcase.ui.export.components.ConfigurationPanelForm;
import org.opendatakit.briefcase.ui.export.components.FormsTable;
import org.opendatakit.briefcase.ui.export.components.FormsTableView;

@SuppressWarnings("checkstyle:MethodName")
public class ExportPanelForm {
  private final ConfigurationPanel confPanel;
  private final FormsTable formsTable;
  private final ConfigurationPanelForm confPanelForm;
  private final FormsTableView formsTableForm;
  private JPanel container;
  private JLabel formsTableLabel;
  private JSeparator formsTableSeparator;
  private JPanel actions;
  private JPanel leftActions;
  private JPanel rightActions;
  private JButton selectAllButton;
  private JButton clearAllButton;
  private JButton exportButton;
  private boolean exporting;

  private ExportPanelForm(ConfigurationPanel confPanel, FormsTable formsTable) {
    this.confPanel = confPanel;
    this.confPanelForm = confPanel.getForm();
    this.formsTable = formsTable;
    this.formsTableForm = formsTable.getView();
    $$$setupUI$$$();

    selectAllButton.addActionListener(__ -> formsTable.selectAll());
    clearAllButton.addActionListener(__ -> formsTable.clearAll());

    exporting = false;
  }

  public static ExportPanelForm from(ExportForms forms, ConfigurationPanel confPanel) {
    return new ExportPanelForm(
        confPanel,
        FormsTable.from(forms)
    );
  }

  public JPanel getContainer() {
    return container;
  }

  public ConfigurationPanel getConfPanel() {
    return confPanel;
  }

  void onExport(Runnable callback) {
    exportButton.addActionListener(__ -> callback.run());
  }

  void onChange(Runnable callback) {
    confPanel.onChange(callback);
    formsTable.onChange(callback);
  }

  void enableExport() {
    exportButton.setEnabled(true);
  }

  void disableExport() {
    exportButton.setEnabled(false);
  }

  void toggleClearAll() {
    selectAllButton.setVisible(false);
    clearAllButton.setVisible(true);
  }

  void toggleSelectAll() {
    selectAllButton.setVisible(true);
    clearAllButton.setVisible(false);
  }

  public void setEnabled(boolean enabled) {
    if (enabled) {
      enableUI();
    } else {
      disableUI();
    }
    setExporting(exporting);
  }

  private void setExporting(boolean active) {
    if (active)
      disableUI();
    else
      enableUI();
    exporting = active;
  }

  void disableUI() {
    for (Component c : container.getComponents())
      c.setEnabled(false);
    container.setEnabled(false);
  }

  void enableUI() {
    for (Component c : container.getComponents())
      c.setEnabled(true);
    container.setEnabled(true);
  }

  public void refresh() {
    formsTable.refresh();
  }


  private void createUIComponents() {
    // Custom creation of components occurs inside the constructor
  }

  /**
   * Method generated by IntelliJ IDEA GUI Designer
   * >>> IMPORTANT!! <<<
   * DO NOT edit this method OR call it in your code!
   *
   * @noinspection ALL
   */
  private void $$$setupUI$$$() {
    createUIComponents();
    container = new JPanel();
    container.setLayout(new GridBagLayout());
    GridBagConstraints gbc;
    gbc = new GridBagConstraints();
    gbc.gridx = 1;
    gbc.gridy = 1;
    gbc.weightx = 1.0;
    gbc.fill = GridBagConstraints.HORIZONTAL;
    container.add(confPanelForm.$$$getRootComponent$$$(), gbc);
    formsTableSeparator = new JSeparator();
    gbc = new GridBagConstraints();
    gbc.gridx = 1;
    gbc.gridy = 3;
    gbc.fill = GridBagConstraints.BOTH;
    container.add(formsTableSeparator, gbc);
    formsTableLabel = new JLabel();
    formsTableLabel.setText("Forms to export:");
    gbc = new GridBagConstraints();
    gbc.gridx = 1;
    gbc.gridy = 4;
    gbc.anchor = GridBagConstraints.WEST;
    container.add(formsTableLabel, gbc);
    actions = new JPanel();
    actions.setLayout(new GridBagLayout());
    gbc = new GridBagConstraints();
    gbc.gridx = 1;
    gbc.gridy = 7;
    gbc.fill = GridBagConstraints.BOTH;
    container.add(actions, gbc);
    leftActions = new JPanel();
    leftActions.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
    gbc = new GridBagConstraints();
    gbc.gridx = 0;
    gbc.gridy = 0;
    gbc.fill = GridBagConstraints.BOTH;
    actions.add(leftActions, gbc);
    selectAllButton = new JButton();
    selectAllButton.setText("Select All");
    leftActions.add(selectAllButton);
    clearAllButton = new JButton();
    clearAllButton.setText("Clear All");
    leftActions.add(clearAllButton);
    final JPanel spacer1 = new JPanel();
    gbc = new GridBagConstraints();
    gbc.gridx = 1;
    gbc.gridy = 0;
    gbc.weightx = 1.0;
    gbc.fill = GridBagConstraints.HORIZONTAL;
    actions.add(spacer1, gbc);
    rightActions = new JPanel();
    rightActions.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
    gbc = new GridBagConstraints();
    gbc.gridx = 2;
    gbc.gridy = 0;
    gbc.fill = GridBagConstraints.BOTH;
    actions.add(rightActions, gbc);
    exportButton = new JButton();
    exportButton.setEnabled(false);
    exportButton.setName("export");
    exportButton.setText("Export");
    rightActions.add(exportButton);
    final JPanel spacer2 = new JPanel();
    gbc = new GridBagConstraints();
    gbc.gridx = 0;
    gbc.gridy = 1;
    gbc.gridwidth = 3;
    gbc.fill = GridBagConstraints.VERTICAL;
    actions.add(spacer2, gbc);
    final JPanel spacer3 = new JPanel();
    gbc = new GridBagConstraints();
    gbc.gridx = 1;
    gbc.gridy = 0;
    gbc.fill = GridBagConstraints.VERTICAL;
    container.add(spacer3, gbc);
    final JPanel spacer4 = new JPanel();
    gbc = new GridBagConstraints();
    gbc.gridx = 2;
    gbc.gridy = 0;
    gbc.gridheight = 8;
    gbc.fill = GridBagConstraints.HORIZONTAL;
    container.add(spacer4, gbc);
    final JPanel spacer5 = new JPanel();
    gbc = new GridBagConstraints();
    gbc.gridx = 0;
    gbc.gridy = 0;
    gbc.gridheight = 8;
    gbc.fill = GridBagConstraints.HORIZONTAL;
    container.add(spacer5, gbc);
    final JPanel spacer6 = new JPanel();
    gbc = new GridBagConstraints();
    gbc.gridx = 1;
    gbc.gridy = 2;
    gbc.fill = GridBagConstraints.VERTICAL;
    container.add(spacer6, gbc);
    final JPanel spacer7 = new JPanel();
    gbc = new GridBagConstraints();
    gbc.gridx = 1;
    gbc.gridy = 6;
    gbc.fill = GridBagConstraints.VERTICAL;
    container.add(spacer7, gbc);
    final JScrollPane scrollPane1 = new JScrollPane();
    gbc = new GridBagConstraints();
    gbc.gridx = 1;
    gbc.gridy = 5;
    gbc.weightx = 1.0;
    gbc.weighty = 1.0;
    gbc.fill = GridBagConstraints.BOTH;
    container.add(scrollPane1, gbc);
    scrollPane1.setViewportView(formsTableForm);
  }

  /**
   * @noinspection ALL
   */
  public JComponent $$$getRootComponent$$$() {
    return container;
  }
}

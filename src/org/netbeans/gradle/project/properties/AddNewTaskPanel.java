package org.netbeans.gradle.project.properties;

@SuppressWarnings("serial")
public class AddNewTaskPanel extends javax.swing.JPanel {

    /**
     * Creates new form AddNewTaskPanel
     */
    public AddNewTaskPanel() {
        initComponents();
    }

    public String getDisplayName() {
        String result = jDisplayName.getText();
        return result != null ? result.trim() : "";
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTaskNameCaption = new javax.swing.JLabel();
        jDisplayName = new javax.swing.JTextField();

        org.openide.awt.Mnemonics.setLocalizedText(jTaskNameCaption, org.openide.util.NbBundle.getMessage(AddNewTaskPanel.class, "AddNewTaskPanel.jTaskNameCaption.text")); // NOI18N

        jDisplayName.setText(org.openide.util.NbBundle.getMessage(AddNewTaskPanel.class, "AddNewTaskPanel.jDisplayName.text")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTaskNameCaption)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDisplayName, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTaskNameCaption)
                    .addComponent(jDisplayName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField jDisplayName;
    private javax.swing.JLabel jTaskNameCaption;
    // End of variables declaration//GEN-END:variables
}
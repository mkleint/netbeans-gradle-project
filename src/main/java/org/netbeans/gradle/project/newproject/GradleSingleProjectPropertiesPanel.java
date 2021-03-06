package org.netbeans.gradle.project.newproject;

import java.io.File;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import org.netbeans.gradle.project.validate.BackgroundValidator;
import org.netbeans.gradle.project.validate.GroupValidator;
import org.netbeans.gradle.project.validate.Validator;
import org.netbeans.gradle.project.validate.Validators;
import org.openide.WizardDescriptor;

@SuppressWarnings("serial")
public final class GradleSingleProjectPropertiesPanel extends javax.swing.JPanel {
    private final GroupValidator validators;
    private final BackgroundValidator bckgValidator;
    private final WizardDescriptor wizard;

    /**
     * Creates new form GradleSingleProjectPropertiesPanel
     */
    public GradleSingleProjectPropertiesPanel(WizardDescriptor wizard) {
        bckgValidator = new BackgroundValidator();
        this.wizard = wizard;

        initComponents();

        validators = new GroupValidator();
        validators.addValidator(
                NewProjectUtils.createClassNameValidator(true),
                Validators.createCollector(jMainClassEdit));

        jProjectLocationEdit.setText(NewProjectUtils.getDefaultProjectDir());

        Validators.connectWizardDescriptorToProblems(bckgValidator, wizard);
        NewProjectUtils.setupNewProjectValidators(bckgValidator, validators,
                jProjectNameEdit, jProjectFolderEdit, jProjectLocationEdit);

        DocumentListener validationPerformer = new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                bckgValidator.performValidation();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                bckgValidator.performValidation();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                bckgValidator.performValidation();
            }
        };
        jMainClassEdit.getDocument().addDocumentListener(validationPerformer);
    }

    public void addProjectLocationValidator(Validator<String> validator) {
        validators.addValidator(
                validator,
                Validators.createCollector(jProjectLocationEdit));
    }

    public void startValidation() {
        bckgValidator.setValidators(validators);
    }

    public void addChangeListener(ChangeListener listener) {
        bckgValidator.addChangeListener(listener);
    }

    public void removeChangeListener(ChangeListener listener) {
        bckgValidator.removeChangeListener(listener);
    }

    public GradleSingleProjectConfig getConfig() {
        String projectName = jProjectNameEdit.getText().trim();
        String projectDirStr = jProjectFolderEdit.getText().trim();
        String mainClass = jMainClassEdit.getText().trim();
        if (mainClass.isEmpty()) mainClass = null;

        if (projectName.isEmpty() || projectDirStr.isEmpty()) {
            return null;
        }

        NewProjectUtils.setDefaultProjectDir(jProjectLocationEdit.getText());

        File projectDir = new File(projectDirStr);
        return new GradleSingleProjectConfig(projectName, projectDir, mainClass);
    }

    public boolean containsValidData() {
        return bckgValidator.isValid();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jProjectNameCaption = new javax.swing.JLabel();
        jProjectNameEdit = new javax.swing.JTextField();
        jProjectLocationCaption = new javax.swing.JLabel();
        jProjectLocationEdit = new javax.swing.JTextField();
        jBrowseButton = new javax.swing.JButton();
        jProjectFolderLocationLabel = new javax.swing.JLabel();
        jProjectFolderEdit = new javax.swing.JTextField();
        jMainClassLabel = new javax.swing.JLabel();
        jMainClassEdit = new javax.swing.JTextField();

        org.openide.awt.Mnemonics.setLocalizedText(jProjectNameCaption, org.openide.util.NbBundle.getMessage(GradleSingleProjectPropertiesPanel.class, "GradleSingleProjectPropertiesPanel.jProjectNameCaption.text")); // NOI18N

        jProjectNameEdit.setText(org.openide.util.NbBundle.getMessage(GradleSingleProjectPropertiesPanel.class, "GradleSingleProjectPropertiesPanel.jProjectNameEdit.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jProjectLocationCaption, org.openide.util.NbBundle.getMessage(GradleSingleProjectPropertiesPanel.class, "GradleSingleProjectPropertiesPanel.jProjectLocationCaption.text")); // NOI18N

        jProjectLocationEdit.setText(org.openide.util.NbBundle.getMessage(GradleSingleProjectPropertiesPanel.class, "GradleSingleProjectPropertiesPanel.jProjectLocationEdit.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jBrowseButton, org.openide.util.NbBundle.getMessage(GradleSingleProjectPropertiesPanel.class, "GradleSingleProjectPropertiesPanel.jBrowseButton.text")); // NOI18N
        jBrowseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBrowseButtonActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jProjectFolderLocationLabel, org.openide.util.NbBundle.getMessage(GradleSingleProjectPropertiesPanel.class, "GradleSingleProjectPropertiesPanel.jProjectFolderLocationLabel.text")); // NOI18N

        jProjectFolderEdit.setText(org.openide.util.NbBundle.getMessage(GradleSingleProjectPropertiesPanel.class, "GradleSingleProjectPropertiesPanel.jProjectFolderEdit.text")); // NOI18N
        jProjectFolderEdit.setEnabled(false);

        org.openide.awt.Mnemonics.setLocalizedText(jMainClassLabel, org.openide.util.NbBundle.getMessage(GradleSingleProjectPropertiesPanel.class, "GradleSingleProjectPropertiesPanel.jMainClassLabel.text")); // NOI18N

        jMainClassEdit.setText(org.openide.util.NbBundle.getMessage(GradleSingleProjectPropertiesPanel.class, "GradleSingleProjectPropertiesPanel.jMainClassEdit.text")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jProjectNameCaption)
                        .addGap(18, 18, 18)
                        .addComponent(jProjectNameEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jProjectLocationCaption)
                            .addComponent(jProjectFolderLocationLabel)
                            .addComponent(jMainClassLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jProjectFolderEdit, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jProjectLocationEdit)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBrowseButton))
                            .addComponent(jMainClassEdit))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jProjectNameCaption)
                    .addComponent(jProjectNameEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jProjectLocationCaption)
                    .addComponent(jProjectLocationEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBrowseButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jProjectFolderEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jProjectFolderLocationLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jMainClassLabel)
                    .addComponent(jMainClassEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(49, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jBrowseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBrowseButtonActionPerformed
        NewProjectUtils.chooseProjectLocation(this, jProjectLocationEdit);
    }//GEN-LAST:event_jBrowseButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBrowseButton;
    private javax.swing.JTextField jMainClassEdit;
    private javax.swing.JLabel jMainClassLabel;
    private javax.swing.JTextField jProjectFolderEdit;
    private javax.swing.JLabel jProjectFolderLocationLabel;
    private javax.swing.JLabel jProjectLocationCaption;
    private javax.swing.JTextField jProjectLocationEdit;
    private javax.swing.JLabel jProjectNameCaption;
    private javax.swing.JTextField jProjectNameEdit;
    // End of variables declaration//GEN-END:variables
}

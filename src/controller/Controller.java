/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;

/**
 *
 * @author ATH
 */
public class Controller {

    private AbsenceController absenceController;
    private RetardController retardController;
    private AnneeController anneeController;
    private ClasseController classeController;
    private ConfigurationController configurationController;
    private CycleController cycleController;
    private EleveController eleveController;
    private EvaluationClasseController evaluationClasseController;
    private EvaluationMatiereController evaluationMatiereController;
    private MatiereClasseController matiereClasseController;
    private MatiereController matiereController;
    private MatiereTypeController matiereTypeController;
    private NationaliteController nationaliteController;
    private NoteEvaluationController noteEvaluationController;
    private ParametreController parametreController;
    private ProfesseurController professeurController;
    private ProfesseurMatiereClasseController professeurMatiereClasseController;
    private SemestreController semestreController;
    private UserController userController;
    private DroitController droitController;
    private JournalController journalController;
    private EvaluationMatiereTypeController evaluationMatiereTypeController;
    private EleveClasseController eleveClasseController;
    private MontantClasseController montantClasseController;
    private TrancheController trancheController;
    private VersementController versementController;
    private PrimaireEvaluationClasseController primaireEvaluationClasseController;
    private PrimaireEvaluationMatiereController primaireEvaluationMatiereController;
    private PrimaireEvaluationMatiereTypeController primaireEvaluationMatiereTypeController;
    private final Connection connection;

    public Controller(Connection connection) {
        this.connection = connection;
    }

    public UserController getUserController() {
        if (userController == null) {
            userController = new UserController(connection);
        }
        return userController;
    }

    public PrimaireEvaluationClasseController getPrimaireEvaluationClasseController() {
        if (primaireEvaluationClasseController == null) {
            primaireEvaluationClasseController = new PrimaireEvaluationClasseController(connection);
        }
        return primaireEvaluationClasseController;
    }

    public PrimaireEvaluationMatiereController getPrimaireEvaluationMatiereController() {
        if (primaireEvaluationMatiereController == null) {
            primaireEvaluationMatiereController = new PrimaireEvaluationMatiereController(connection);
        }
        return primaireEvaluationMatiereController;
    }

    public PrimaireEvaluationMatiereTypeController getPrimaireEvaluationMatiereTypeController() {
        if (primaireEvaluationMatiereTypeController == null) {
            primaireEvaluationMatiereTypeController = new PrimaireEvaluationMatiereTypeController(connection);
        }
        return primaireEvaluationMatiereTypeController;
    }

    public EleveClasseController getEleveClasseController() {
        if (eleveClasseController == null) {
            eleveClasseController = new EleveClasseController(connection);
        }
        return eleveClasseController;
    }

    public EvaluationMatiereTypeController getEvaluationMatiereTypeController() {
        if (evaluationMatiereTypeController == null) {
            evaluationMatiereTypeController = new EvaluationMatiereTypeController(connection);
        }
        return evaluationMatiereTypeController;
    }

    public JournalController getJournalController() {
        if (journalController == null) {
            journalController = new JournalController(connection);
        }
        return journalController;
    }

    public DroitController getDroitController() {
        if (droitController == null) {
            droitController = new DroitController(connection);
        }
        return droitController;
    }

    public MatiereTypeController getMatiereTypeController() {
        if (matiereTypeController == null) {
            matiereTypeController = new MatiereTypeController(connection);
        }
        return matiereTypeController;
    }

    public AbsenceController getAbsenceController() {
        if (absenceController == null) {
            absenceController = new AbsenceController(connection);
        }
        return absenceController;
    }

    public RetardController getRetardController() {
        if (retardController == null) {
            retardController = new RetardController(connection);
        }
        return retardController;
    }

    public AnneeController getAnneeController() {
        if (anneeController == null) {
            anneeController = new AnneeController(connection);
        }
        return anneeController;
    }

    public ClasseController getClasseController() {
        if (classeController == null) {
            classeController = new ClasseController(connection);
        }
        return classeController;
    }

    public ConfigurationController getConfigurationController() {
        if (configurationController == null) {
            configurationController = new ConfigurationController(connection);
        }
        return configurationController;
    }

    public CycleController getCycleController() {
        if (cycleController == null) {
            cycleController = new CycleController(connection);
        }
        return cycleController;
    }

    public EleveController getEleveController() {
        if (eleveController == null) {
            eleveController = new EleveController(connection);
        }
        return eleveController;
    }

    public EvaluationClasseController getEvaluationClasseController() {
        if (evaluationClasseController == null) {
            evaluationClasseController = new EvaluationClasseController(connection);
        }
        return evaluationClasseController;
    }

    public EvaluationMatiereController getEvaluationMatiereController() {
        if (evaluationMatiereController == null) {
            evaluationMatiereController = new EvaluationMatiereController(connection);
        }
        return evaluationMatiereController;
    }

    public MatiereClasseController getMatiereClasseController() {
        if (matiereClasseController == null) {
            matiereClasseController = new MatiereClasseController(connection);
        }
        return matiereClasseController;
    }

    public MatiereController getMatiereController() {
        if (matiereController == null) {
            matiereController = new MatiereController(connection);
        }
        return matiereController;
    }

    public NationaliteController getNationaliteController() {
        if (nationaliteController == null) {
            nationaliteController = new NationaliteController(connection);
        }
        return nationaliteController;
    }

    public NoteEvaluationController getNoteEvaluationController() {
        if (noteEvaluationController == null) {
            noteEvaluationController = new NoteEvaluationController(connection);
        }
        return noteEvaluationController;
    }

    public ParametreController getParametreController() {
        if (parametreController == null) {
            parametreController = new ParametreController(connection);
        }
        return parametreController;
    }

    public ProfesseurController getProfesseurController() {
        if (professeurController == null) {
            professeurController = new ProfesseurController(connection);
        }
        return professeurController;
    }

    public ProfesseurMatiereClasseController getProfesseurMatiereClasseController() {
        if (professeurMatiereClasseController == null) {
            professeurMatiereClasseController = new ProfesseurMatiereClasseController(connection);
        }
        return professeurMatiereClasseController;
    }

    public SemestreController getSemestreController() {
        if (semestreController == null) {
            semestreController = new SemestreController(connection);
        }
        return semestreController;
    }

    public MontantClasseController getMontantClasseController() {
        if (montantClasseController == null) {
            montantClasseController = new MontantClasseController(connection);
        }
        return montantClasseController;
    }

    public TrancheController getTrancheController() {
        if (trancheController == null) {
            trancheController = new TrancheController(connection);
        }
        return trancheController;
    }

    public VersementController getVersementController() {
        if (versementController == null) {
            versementController = new VersementController(connection);
        }
        return versementController;
    }

    public Connection getConnection() {
        return connection;
    }

}

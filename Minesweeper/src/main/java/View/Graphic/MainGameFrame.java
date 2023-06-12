package View.Graphic;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.*;

import Controller.GraphicController;

import java.awt.*;

public class MainGameFrame extends JFrame {

    private GraphicController controller;
    //private Model model;
    private int fWidth;
    private int fHeight;
    private int mineCount;
    private int left;
    MenuManager manager;
    LevelDialog levelDialog;
    private CellPanel[][] cellPanel;
    private JMenuBar menuBar;
    private JMenu optionsMenu;
    private JMenuItem exit;
    private JMenuItem about;
    //  private JMenuItem scores;
    private JMenuItem level;
    private JButton smileButton;
    private JPanel mainPanel;
    private JPanel infoPanel;
    private JPanel fieldPanel;
    private JLabel time;
    private JLabel mines;

    public MainGameFrame(/*Model model*/ GraphicController controller, int fWidth, int fHeight, int mineCount) {
        this.controller = controller;
       // this.model = model;
        this.fWidth = fWidth;
        this.fHeight = fHeight;
        this.mineCount = mineCount;
        this.left = mineCount;
        //model.events.subscribeAll(this);
    }

    public void prepareGUI() {

        setResizable(false);
        setSize(fWidth * 30 + 10, fHeight * 30 + 120);
        setLocationRelativeTo(null);
        setMinimumSize(new Dimension(200, 300));
        setMaximumSize(Toolkit.getDefaultToolkit().getScreenSize());
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        menuBar = createMenuBar();
        setJMenuBar(menuBar);
        mainPanel = createMainPanel();
        infoPanel = createInfoPanel();
        mainPanel.add(infoPanel);
        fieldPanel = createFieldPanel();
        mainPanel.add(fieldPanel);
        add(mainPanel);
        addMenuListeners();
    }

    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        manager = new MenuManager();
        optionsMenu = manager.getOptionsMenu();
        menuBar.add(optionsMenu);
        about = manager.getAboutItem();
        exit = manager.getExitItem();
        level = manager.getLevelItem();
        return menuBar;
    }

    private JPanel createMainPanel() {
        JPanel p = new JPanel();
        p.setBorder(new CompoundBorder(new EmptyBorder(5, 5, 5, 5), new BevelBorder(BevelBorder.LOWERED)));
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
        return p;
    }

    private JPanel createInfoPanel() {
        JPanel p = new JPanel();
        smileButton = new JButton();
        smileButton.setPreferredSize(new Dimension(33, 33));
        smileButton.setIcon(new ImageIcon("build/resources/main/pictures/smile.png"));
        time = new JLabel("<html><body bgcolor=black><font size=100 color=red><b>000</b>");
        String minesString = Integer.toString(mineCount / 100) + Integer.toString(mineCount % 100 / 10) + Integer.toString(mineCount % 10);
        mines = new JLabel("<html><body bgcolor=black><font size=100 color=red><b>" + minesString + "</b>");
        p.setLayout(new GridBagLayout());
        p.setMaximumSize(new Dimension(300, 100));
        p.add(time);
        p.add(smileButton);
        p.add(mines);
        p.setBorder(new CompoundBorder(new EmptyBorder(1, 2, 2, 2), new EtchedBorder()));
        return p;
    }

    private JPanel createFieldPanel() {
        JPanel p = new JPanel();
        p.setBorder(new CompoundBorder(new EmptyBorder(2, 2, 2, 2), new EtchedBorder()));
        p.setLayout(new GridLayout(fHeight, fWidth));
        EtchedBorder border = new EtchedBorder(EtchedBorder.LOWERED);
        for (int i = 0; i < fHeight; i++) {
            for (int j = 0; j < fWidth; j++) {
                cellPanel[j][i] = new CellPanel(j, i);
                cellPanel[j][i].setBorder(border);
                p.add(cellPanel[j][i]);
            }
        }
        return p;
    }

    public void addMenuListeners() {
        exit.addActionListener(e -> {
            this.dispose();
        });
        about.addActionListener(e -> {
            JOptionPane.showMessageDialog(
                    MainGameFrame.this,
                    "<html><h2>This is Minesweeper Game<br>",
                    "About",
                    JOptionPane.PLAIN_MESSAGE);
        });
        level.addActionListener(e -> {
            createLevelDialog();
        });
    }

    private void createLevelDialog() {
        if (levelDialog == null) {
            levelDialog = new LevelDialog(this, controller);

        } else {
            levelDialog.setVisible(true);
        }
    }
}

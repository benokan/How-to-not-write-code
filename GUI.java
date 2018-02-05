import java.awt.EventQueue;
import jm.JMC;
import jm.music.data.*;
import jm.util.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSlider;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JLabel;

public class GUI extends JFrame implements JMC {

	private String[] displayNotes = { "X", "C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B" };
	private String[] notes = { "X", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X" };
	private String[] displayInstruments = { "Choose your Instrument", "Piano", "Guitar", "Synth", "Organ", "Random" };

	Part mp = new Part();
	Score sc = new Score();
	Phrase p = new Phrase();
	private JPanel contentPane;

	public void restart() { // Restart Function for changes at run-time.
		try {
			Play.stopMidi();

		} catch (StackOverflowError sf) {
			System.out.println("Stop.");
		}

		sc.removeAllParts();
		mp.removeAllPhrases();
		p.empty();

		for (int i = 0; i < notes.length; i++) {
			Match(i, notes);
		}

		mp.addPhrase(p);
		sc.addPart(mp);

		Play.midiCycle(sc);
	}

	public void Match(int index, String[] notes) {
		switch (notes[index]) {
		case "X":
			Note restNote = new Note(REST, QUARTER_NOTE);
			p.addNote(restNote);
			break;
		case "C":
			Note C = new Note(60, QUARTER_NOTE);
			p.addNote(C);
			break;
		case "C#":
			Note Csharp = new Note(61, QUARTER_NOTE);
			p.addNote(Csharp);
			break;
		case "D":
			Note D = new Note(62, QUARTER_NOTE);
			p.addNote(D);
			break;
		case "D#":
			Note Dsharp = new Note(63, QUARTER_NOTE);
			p.addNote(Dsharp);
			break;
		case "E":
			Note E = new Note(64, QUARTER_NOTE);
			p.addNote(E);
			break;
		case "F":
			Note F = new Note(65, QUARTER_NOTE);
			p.addNote(F);
			break;
		case "F#":
			Note Fsharp = new Note(66, QUARTER_NOTE);
			p.addNote(Fsharp);
			break;
		case "G":
			Note G = new Note(67, QUARTER_NOTE);
			p.addNote(G);
			break;
		case "G#":
			Note Gsharp = new Note(68, QUARTER_NOTE);
			p.addNote(Gsharp);
			break;
		case "A":
			Note A = new Note(69, QUARTER_NOTE);
			p.addNote(A);
			break;
		case "A#":
			Note Asharp = new Note(70, QUARTER_NOTE);
			p.addNote(Asharp);
			break;
		case "B":
			Note B = new Note(71, QUARTER_NOTE);
			p.addNote(B);
			break;

		default:
			System.out.println("Default Error.");

		}

	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();

				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUI() {
		setTitle("Sequencer");

		sc.setTempo(170); // same value with -> JSlider slider.setValue(170);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1920, 1080);

		contentPane = new JPanel();

		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		// **************************** COMBO BOXES **************************** //

		JComboBox comboBox = new JComboBox(displayNotes);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String x = (String) comboBox.getSelectedItem();
				notes[0] = x;

			}
		});
		comboBox.setBounds(10, 54, 40, 40);
		contentPane.add(comboBox);

		JComboBox comboBox_1 = new JComboBox(displayNotes);
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String x = (String) comboBox_1.getSelectedItem();
				notes[8] = x;

			}
		});
		comboBox_1.setBounds(10, 163, 40, 40);
		contentPane.add(comboBox_1);

		JComboBox comboBox_2 = new JComboBox(displayNotes);
		comboBox_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String x = (String) comboBox_2.getSelectedItem();
				notes[1] = x;
			}
		});
		comboBox_2.setBounds(86, 54, 40, 40);
		contentPane.add(comboBox_2);

		JComboBox comboBox_3 = new JComboBox(displayNotes);
		comboBox_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String x = (String) comboBox_3.getSelectedItem();
				notes[9] = x;
			}
		});
		comboBox_3.setBounds(86, 163, 40, 40);
		contentPane.add(comboBox_3);

		JComboBox comboBox_4 = new JComboBox(displayNotes);
		comboBox_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String x = (String) comboBox_4.getSelectedItem();
				notes[2] = x;
			}
		});
		comboBox_4.setBounds(161, 54, 40, 40);
		contentPane.add(comboBox_4);

		JComboBox comboBox_5 = new JComboBox(displayNotes);
		comboBox_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String x = (String) comboBox_5.getSelectedItem();
				notes[10] = x;
			}
		});
		comboBox_5.setBounds(161, 163, 40, 40);
		contentPane.add(comboBox_5);

		JComboBox comboBox_6 = new JComboBox(displayNotes);
		comboBox_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String x = (String) comboBox_6.getSelectedItem();
				notes[3] = x;
			}
		});
		comboBox_6.setBounds(236, 54, 40, 40);
		contentPane.add(comboBox_6);

		JComboBox comboBox_7 = new JComboBox(displayNotes);
		comboBox_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String x = (String) comboBox_7.getSelectedItem();
				notes[11] = x;
			}
		});
		comboBox_7.setBounds(236, 163, 40, 40);
		contentPane.add(comboBox_7);

		JComboBox comboBox_8 = new JComboBox(displayNotes);
		comboBox_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String x = (String) comboBox_8.getSelectedItem();
				notes[4] = x;
			}
		});
		comboBox_8.setBounds(314, 54, 40, 40);
		contentPane.add(comboBox_8);

		JComboBox comboBox_9 = new JComboBox(displayNotes);
		comboBox_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String x = (String) comboBox_9.getSelectedItem();
				notes[12] = x;
			}
		});
		comboBox_9.setBounds(314, 163, 40, 40);
		contentPane.add(comboBox_9);

		JComboBox comboBox_10 = new JComboBox(displayNotes);
		comboBox_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String x = (String) comboBox_10.getSelectedItem();
				notes[5] = x;
			}
		});
		comboBox_10.setBounds(391, 54, 40, 40);
		contentPane.add(comboBox_10);

		JComboBox comboBox_11 = new JComboBox(displayNotes);
		comboBox_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String x = (String) comboBox_11.getSelectedItem();
				notes[13] = x;
			}
		});
		comboBox_11.setBounds(391, 163, 40, 40);
		contentPane.add(comboBox_11);

		JComboBox comboBox_12 = new JComboBox(displayNotes);
		comboBox_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String x = (String) comboBox_12.getSelectedItem();
				notes[6] = x;
			}
		});
		comboBox_12.setBounds(473, 54, 40, 40);
		contentPane.add(comboBox_12);

		JComboBox comboBox_13 = new JComboBox(displayNotes);
		comboBox_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String x = (String) comboBox_13.getSelectedItem();
				notes[14] = x;
			}
		});
		comboBox_13.setBounds(473, 163, 40, 40);
		contentPane.add(comboBox_13);

		JComboBox comboBox_14 = new JComboBox(displayNotes);
		comboBox_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String x = (String) comboBox_14.getSelectedItem();
				notes[7] = x;
			}
		});
		comboBox_14.setBounds(549, 54, 40, 40);
		contentPane.add(comboBox_14);

		JComboBox comboBox_15 = new JComboBox(displayNotes);
		comboBox_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String x = (String) comboBox_15.getSelectedItem();
				notes[15] = x;
			}
		});
		comboBox_15.setBounds(549, 163, 40, 40);
		contentPane.add(comboBox_15);

		// Tempo JSlider B

		JSlider slider = new JSlider(40, 300);
		slider.setMajorTickSpacing(65);
		slider.setToolTipText("");
		slider.setValue(170);
		slider.setPaintTicks(true);
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				if (sc.getTempo() != slider.getValue()) {

					try {
						Play.stopMidi();

					} catch (StackOverflowError sf) {
						System.out.println("Stop.");
					}

					sc.removeAllParts();
					mp.removeAllPhrases();
					p.empty();

					sc.setTempo(slider.getValue());

					for (int i = 0; i < notes.length; i++) {
						Match(i, notes);
					}

					mp.addPhrase(p);
					sc.addPart(mp);

					Play.midiCycle(sc);

				}
			}
		});
		slider.setPaintLabels(true);
		slider.setMinorTickSpacing(10);
		slider.setBounds(249, 327, 200, 57);
		contentPane.add(slider);

		// Tempo JSlider E

		// **************************** BUTTONS **************************** //

		// Start Button

		JButton btnNewButton = new JButton("Start");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				for (int i = 0; i < notes.length; i++) {
					Match(i, notes);
				}

				mp.addPhrase(p);
				sc.addPart(mp);

				Play.midiCycle(sc);
			}
		});
		btnNewButton.setBounds(10, 327, 191, 23);
		contentPane.add(btnNewButton);

		// Stop Button

		JButton btnNewButton_1 = new JButton("Stop");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Play.stopMidi();

				} catch (StackOverflowError sf) {
					System.out.println("Stop.");
				}

				sc.removeAllParts();
				mp.removeAllPhrases();
				p.empty();

			}
		});
		btnNewButton_1.setBounds(10, 361, 191, 23);
		contentPane.add(btnNewButton_1);

		// Adv. Setting Button

		JButton btnNewButton_2 = new JButton("Jmusic Menu");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				View.notate(sc);
			}
		});
		btnNewButton_2.setBounds(10, 395, 191, 23);
		contentPane.add(btnNewButton_2);

		JLabel lblTempol = new JLabel("                        Tempo");
		lblTempol.setBounds(260, 302, 179, 14);
		contentPane.add(lblTempol);

		// Instruments ComboBox

		JComboBox comboBox_16 = new JComboBox(displayInstruments);
		comboBox_16.setBounds(10, 429, 191, 62);
		contentPane.add(comboBox_16);

		JButton btnNewButton_3 = new JButton("Exit");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnNewButton_3.setBounds(10, 502, 191, 23);
		contentPane.add(btnNewButton_3);
		comboBox_16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String x = (String) comboBox_16.getSelectedItem();
				if (x == "Piano") {
					mp.setInstrument(0);
					restart();
				} else if (x == "Guitar") {
					mp.setInstrument(24);
					restart();
				} else if (x == "Synth") {
					mp.setInstrument(90);
					restart();
				} else if (x == "Organ") {
					mp.setInstrument(16);
					restart();
				} else if (x == "Random") {
					int randomInstrument = 0 + (int) (Math.random() * 100);
					mp.setInstrument(randomInstrument);
					restart();
				}

			}
		});

	}

}

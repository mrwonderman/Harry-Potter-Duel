package ch.halcyon.hpduel;

import java.util.Random;

public class DuelLogic {

	private static int stupify = 10;
	private static int impedimenta = 10;
	private static int furnunculus = 10;
	private static int expelliarmus = 10;
	private static int playerHealth = 50;
	private static int voldemortHealth = 50;
	private static int numberOfDuels = 0;

	public static String duel(int spell) {
		setNumberOfDuels(getNumberOfDuels() + 1);
		Random rng = new Random();
		return getResult(spell, rng.nextInt(5) + 1);

	}

	private static String getResult(int spell, int voldemortSpell) {
		if (spell == 1) {
			// Outcome of Stupefy vs. Stupefy
			if (voldemortSpell == 1 && stupify == 10) {
				setVoldemortHealth(getVoldemortHealth() - 10);
				setPlayerHealth(getPlayerHealth() - 10);
				return "\nVoldemort uses Stupefy. "
						+ "Both players take damage.\n";
			}
			// Outcome of trained Stupefy vs. Stupefy
			if (voldemortSpell == 1 && stupify > 10) {
				setVoldemortHealth(getVoldemortHealth() - stupify);
				return "\nVoldemort uses Stupefy " + "and takes damage.\n";
			}
			// Outcome of Stupefy vs. Impedimenta
			if (voldemortSpell == 2) {
				setVoldemortHealth(getVoldemortHealth() - stupify);
				return "\nVoldemort uses Impedimenta " + "and takes damage.\n";
			}
			// Outcome of Stupefy vs. Furnunculus
			if (voldemortSpell == 3) {
				return "\nVoldemort uses Furnunculus. "
						+ "No damage to either player.\n";
			}
			// Outcome of Stupefy vs. Expelliarmus
			if (voldemortSpell == 4) {
				setPlayerHealth(getPlayerHealth() - 10);
				return "\nVoldemort uses Expelliarmus. "
						+ "Player takes damage.\n";
			}
			// Outcome of Stupefy vs. Protego
			if (voldemortSpell == 5) {
				return "\nVoldemort blocks spell with Protego.\n";
			}
		}

		// All possible outcomes of Impedimenta
		if (spell == 2) {
			// Outcome of Impedimenta vs. Stupefy
			if (voldemortSpell == 1) {
				setPlayerHealth(getPlayerHealth() - 10);
				return "\nVoldemort uses Stupefy. " + "Player takes damage.\n";
			}
			// Outcome of Impedimenta vs. Impedimenta
			if (voldemortSpell == 2 && impedimenta == 10) {
				setVoldemortHealth(getVoldemortHealth() - 10);
				setPlayerHealth(getPlayerHealth() - 10);
				return "\nVoldemort uses Impedimenta. "
						+ "Both players take damage.\n";
			}
			// Outcome of trained Impedimenta vs.
			// Impedimenta
			if (voldemortSpell == 2 && impedimenta > 10) {
				setVoldemortHealth(getVoldemortHealth() - impedimenta);
				return "\nVoldemort uses Impedimenta " + "and takes damage.\n";
			}
			// Outcome of Impedimenta vs. Furnunculus
			if (voldemortSpell == 3) {
				setVoldemortHealth(getVoldemortHealth() - impedimenta);
				return "\nVoldemort uses Furnunculus " + "and takes damage.\n";
			}
			// Outcome of Impedimenta vs. Expelliarmus
			if (voldemortSpell == 4 && impedimenta == 10) {
				setVoldemortHealth(getVoldemortHealth() - 10);
				setPlayerHealth(getPlayerHealth() - 10);
				return "\nVoldemort uses Expelliarmus. "
						+ "Both players take damage.\n";
			}
			// Outcome of trained Impedimenta vs.
			// Expelliarmus
			if (voldemortSpell == 4 && impedimenta > 10) {
				setVoldemortHealth(getVoldemortHealth() - impedimenta);
				return "\nVoldemort uses Expelliarmus " + "and takes damage.\n";
			}
			// Outcome of Impedimenta vs. Protego
			if (voldemortSpell == 5) {
				return "\nVoldemort blocks spell with Protego.\n";
			}
		}

		// All possible outcomes of Furnunculus
		if (spell == 3) {
			// Outcome of Furnunculus vs. Stupefy
			if (voldemortSpell == 1) {
				return "\nVoldemort uses Stupefy. "
						+ "No damage to either player.\n";
			}
			// Outcome of Furnunculus vs. Impedimenta
			if (voldemortSpell == 2) {
				setPlayerHealth(getPlayerHealth() - 10);
				return "\nVoldemort uses Impedimenta. "
						+ "Player takes damage.\n";
			}
			// Outcome of Furnunculus vs. Furnunculus
			if (voldemortSpell == 3 && furnunculus == 10) {
				setVoldemortHealth(getVoldemortHealth() - 10);
				setPlayerHealth(getPlayerHealth() - 10);
				return "\nVoldemort uses Furnunculus. "
						+ "Both players take damage.\n";

			}
			// Outcome of trained Furnunculus vs.
			// Furnunculus
			if (voldemortSpell == 3 && furnunculus > 10) {
				setVoldemortHealth(getVoldemortHealth() - furnunculus);
				return "\nVoldemort uses Furnunculus " + "and takes damage.\n";
			}
			// Outcome of Furnunculus vs. Expelliarmus
			if (voldemortSpell == 4) {
				setVoldemortHealth(getVoldemortHealth() - furnunculus);
				return "\nVoldemort uses Expelliarmus " + "and takes damage.\n";
			}
			// Outcome of Furnunculus vs. Protego
			if (voldemortSpell == 5) {
				return "\nVoldemort blocks " + "spell with Protego.\n";
			}
		}

		// All possible outcomes of Expelliarmus
		if (spell == 4) {
			// Outcome of Expelliarmus vs. Stupefy
			if (voldemortSpell == 1) {
				setVoldemortHealth(getVoldemortHealth() - expelliarmus);
				return "\nVoldemort uses Stupefy " + "and takes damage.\n";
			}
			// Outcome of Expelliarmus vs. Impedimenta
			if (voldemortSpell == 2 && expelliarmus == 10) {
				setVoldemortHealth(getVoldemortHealth() - 10);
				setPlayerHealth(getPlayerHealth() - 10);
				return "\nVoldemort uses Impedimenta. "
						+ "Both players take damage.\n";
			}
			// Outcome of trained Expelliarmus vs.
			// Impedimenta
			if (voldemortSpell == 2 && expelliarmus > 10) {
				setVoldemortHealth(getVoldemortHealth() - expelliarmus);
				return "\nVoldemort uses Impedimenta " + "and takes damage.\n";
			}
			// Outcome of Expelliarmus vs. Furnunculus
			if (voldemortSpell == 3) {
				setPlayerHealth(getPlayerHealth() - 10);
				return "\nVoldemort uses Furnunculus. "
						+ "Player takes damage.\n";
			}
			// Outcome of Expelliarmus vs. Expelliarmus
			if (voldemortSpell == 4 && expelliarmus == 10) {
				setVoldemortHealth(getVoldemortHealth() - 10);
				setPlayerHealth(getPlayerHealth() - 10);
				return "\nVoldemort uses expelliarmus. "
						+ "Both players take damage.\n";
			}
			// Outcome of trained Expelliarmus vs.
			// Expelliarmus
			if (voldemortSpell == 4 && expelliarmus > 10) {
				setVoldemortHealth(getVoldemortHealth() - expelliarmus);
				return "\nVoldeort uses expelliarmus " + "and takes damage.\n";
			}
			// Outcome of Expelliarmus vs. Protego
			if (voldemortSpell == 5) {
				return "\nVoldemort blocks " + "spell with Protego.\n";
			}
		}

		// Outcome of Protego
		if (spell == 5) {
			return "\nYou blocked Voldemort's "
					+ "spell with Protego. No damage.\n";
		}
		return "";

	}

	public static int getPlayerHealth() {
		return playerHealth;
	}

	public static void setPlayerHealth(int playerHealth) {
		DuelLogic.playerHealth = playerHealth;
	}

	public static int getVoldemortHealth() {
		return voldemortHealth;
	}

	public static void setVoldemortHealth(int voldemortHealth) {
		DuelLogic.voldemortHealth = voldemortHealth;
	}

	public static int getNumberOfDuels() {
		return numberOfDuels;
	}

	public static void setNumberOfDuels(int numberOfDuels) {
		DuelLogic.numberOfDuels = numberOfDuels;
	}

}

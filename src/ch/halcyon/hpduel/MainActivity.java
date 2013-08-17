package ch.halcyon.hpduel;

import android.app.Activity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends Activity {
	boolean restart = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		final Spinner spinner = (Spinner) this.findViewById(R.id.spinner1);
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
				getBaseContext(), R.array.spells,
				android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(adapter);

		final TextView textView = (TextView) findViewById(R.id.textView1);
		textView.setMovementMethod(ScrollingMovementMethod.getInstance());

		final TextView ownPoints = (TextView) findViewById(R.id.ownText);
		final TextView voldiPoints = (TextView) findViewById(R.id.voldiPoints);

		final ProgressBar ownProgress = (ProgressBar) findViewById(R.id.progressBar1);
		ownProgress.setMax(50);
		ownProgress.setProgress(50);

		final ProgressBar voldiProgress = (ProgressBar) findViewById(R.id.progressBar2);
		voldiProgress.setMax(50);
		voldiProgress.setProgress(50);
		voldiProgress.setRotation(180);

		final Button cast = (Button) findViewById(R.id.button1);
		cast.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				if (!restart) {
					String fieldText = "";
					if (DuelLogic.getVoldemortHealth() > 0
							&& DuelLogic.getPlayerHealth() > 0) {
						fieldText = DuelLogic.duel(spinner
								.getSelectedItemPosition() + 1);
						ownPoints.setText(String.valueOf(DuelLogic
								.getPlayerHealth()));
						ownProgress.setProgress(DuelLogic.getPlayerHealth());
						voldiPoints.setText(String.valueOf(DuelLogic
								.getVoldemortHealth()));
						voldiProgress.setProgress(DuelLogic
								.getVoldemortHealth());
					} else {
						fieldText = checkDeath();
					}
					if ((DuelLogic.getVoldemortHealth() == 0)
							|| (DuelLogic.getPlayerHealth() == 0)) {
						fieldText = checkDeath();
					}
					voldiPoints.setText(String.valueOf(DuelLogic
							.getVoldemortHealth()));
					voldiProgress.setProgress(DuelLogic.getVoldemortHealth());
					textView.append(fieldText);

				} else {
					DuelLogic.setPlayerHealth(50);
					DuelLogic.setVoldemortHealth(50);
					DuelLogic.setNumberOfDuels(0);
					ownPoints.setText(String.valueOf(50));
					voldiPoints.setText(String.valueOf(50));
					ownProgress.setProgress(50);
					voldiProgress.setProgress(50);
					textView.setText("");
					cast.setText("cast");
					restart = false;
				}
			}

			private String checkDeath() {
				String fieldText = "";
				if (DuelLogic.getVoldemortHealth() == 0) {
					fieldText = "\nCongratulations you have defeated Voldemort with "
							+ DuelLogic.getPlayerHealth() + " health!";
				}
				if (DuelLogic.getPlayerHealth() == 0) {
					fieldText = "\nSorry, you have been defeated by Voldemort with "
							+ DuelLogic.getVoldemortHealth() + " health.";
				}
				ownPoints.setText(String.valueOf(DuelLogic.getPlayerHealth()));
				voldiPoints.setText(String.valueOf(DuelLogic
						.getVoldemortHealth()));

				textView.append(fieldText);

				fieldText = "\n\nPlayer Health: " + DuelLogic.getPlayerHealth()
						+ "\nVoldemort Health: "
						+ DuelLogic.getVoldemortHealth()
						+ "\nNumber of Duels: " + DuelLogic.getNumberOfDuels()
						+ "\n";
				restart = true;
				cast.setText("restart");
				return fieldText;
			}
		});

	}
}

package id.ac.polinema.tebakangka;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.text.TextUtils;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

	//  TODO: deklarasikan variabel di sini
	private EditText numberInput;

	private Button btnTebak;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// TODO: bind layout di sini
		numberInput = findViewById(R.id.number_input);
		btnTebak = findViewById(R.id.guess_button);
	}

	// TODO: generate angka random di sini
	private int initRandomNumber() {
		Random random = new Random();
		return random.nextInt(100) + 1;
	}

	public void handleGuess(View view) {
		// TODO: Tambahkan logika untuk melakukan pengecekan angka

		int randomNumber = initRandomNumber();

		String name = numberInput.getText().toString();

		if (TextUtils.isEmpty(name)) {
			Toast.makeText(this, "Jawaban harus diisi!", Toast.LENGTH_SHORT).show();
		} else {
			int number = Integer.parseInt(name);

			if (number == randomNumber){
				Toast.makeText(this, "Tebakan anda benar!, Jawabannya "+ randomNumber + " Kamu Menjawab " + number, Toast.LENGTH_SHORT).show();
				btnTebak.setEnabled(false);
			} else if (number > randomNumber) {
				Toast.makeText(this, "Tebakan anda terlalu besar!, Jawabannya "+ randomNumber + " Kamu Menjawab " + number, Toast.LENGTH_SHORT).show();
			} else if (number < randomNumber) {
				Toast.makeText(this, "Tebakan anda terlalu kecil!, Jawabannya "+ randomNumber + " Kamu Menjawab " + number, Toast.LENGTH_SHORT).show();
			}
		}
	}

	public void handleReset(View view) {
		// TODO: Reset tampilan

		btnTebak.setEnabled(true);
		numberInput.setText("");
	}
}

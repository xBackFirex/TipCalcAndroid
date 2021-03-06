package com.example.zachary.tipcalculator;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity
{
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);

		/*
		FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
		fab.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View view)
			{
				Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
						.setAction("Action", null).show();
			}
		});
		*/
	}

	public void buttonClick(View view) throws IOException
	{
		// get method values

		EditText cost = (EditText) findViewById(R.id.textCost);
		EditText people = (EditText) findViewById(R.id.textNumPeople);
		EditText tip = (EditText) findViewById(R.id.textPercTip);

		TextView resultTip = (TextView) findViewById(R.id.resultTip);
		TextView resultTotal = (TextView) findViewById(R.id.resultTotal);
		TextView resultPerPerson = (TextView) findViewById(R.id.resultPerPerson);

		// set method calues

		double costOfMeal;
		int numOfPeople;
		double percTip;
		double tipAmt;
		double totalAmt;
		double perPersonAmt;

		String strCost;
		String strPeople;
		String strTip;

		String strResultTip;
		String strResultTotal;
		String strResultPerPerson;

		// initialize string values

		strCost = cost.getText().toString();
		strPeople = people.getText().toString();
		strTip = tip.getText().toString();

		// check not null fields
		try {
			if ((strCost != null) && (strCost != "") && (strPeople != null) && (strPeople != "") && (strTip != null) && (strTip != ""))
			{
				// initialize values

				costOfMeal = Double.parseDouble(strCost);
				numOfPeople = Integer.parseInt(strPeople);
				percTip = Double.parseDouble(strTip);
				percTip = percTip / 100;

				// calculate values

				tipAmt = (costOfMeal * percTip);
				totalAmt = (costOfMeal + tipAmt);
				perPersonAmt = (totalAmt / numOfPeople);

				// format values

				DecimalFormat currencyUSD = new DecimalFormat("$###,##0.00");
				currencyUSD.setDecimalSeparatorAlwaysShown(true);

				strResultTip = (currencyUSD.format(tipAmt));
				strResultTotal = (currencyUSD.format(totalAmt));
				strResultPerPerson = (currencyUSD.format(perPersonAmt));

				// set display values

				resultTip.setText(strResultTip);
				resultTotal.setText(strResultTotal);
				resultPerPerson.setText(strResultPerPerson);
			}
		} catch (Exception e)
		{
			Toast toast = Toast.makeText(this, "Invalid Input(s)", Toast.LENGTH_SHORT);
			toast.show();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();

		//noinspection SimplifiableIfStatement
		if (id == R.id.action_clear) {
			// get method values
			EditText cost = (EditText) findViewById(R.id.textCost);
			EditText people = (EditText) findViewById(R.id.textNumPeople);
			EditText tip = (EditText) findViewById(R.id.textPercTip);

			TextView resultTip = (TextView) findViewById(R.id.resultTip);
			TextView resultTotal = (TextView) findViewById(R.id.resultTotal);
			TextView resultPerPerson = (TextView) findViewById(R.id.resultPerPerson);

			cost.setText("");
			people.setText("");
			tip.setText("");
			resultTip.setText("$0.00");
			resultTotal.setText("$0.00");
			resultPerPerson.setText("$0.00");

			return true;
		}

		return super.onOptionsItemSelected(item);
	}
}

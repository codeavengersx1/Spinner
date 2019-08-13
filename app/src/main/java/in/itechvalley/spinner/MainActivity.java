package in.itechvalley.spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnItemSelected;

public class MainActivity extends AppCompatActivity
{
    @BindView(R.id.simple_spinner)
    AutoCompleteTextView spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        * Attach ButterKnife to this Activity
        * */
        ButterKnife.bind(this);

        /*
        * Simple List for Spinner
        * */
        List<String> listContainingSpinnerItems = new ArrayList<>();
        listContainingSpinnerItems.add("Select your Designation");
        listContainingSpinnerItems.add("Mr.");
        listContainingSpinnerItems.add("Mrs.");
        listContainingSpinnerItems.add("Miss");
        listContainingSpinnerItems.add("Master");

        /*
        * Simple ArrayAdapter for Spinner
        * */
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<>(
            MainActivity.this,
            android.R.layout.simple_list_item_1,
            android.R.id.text1,
            listContainingSpinnerItems);

        spinner.setAdapter(stringArrayAdapter);
    }

    /*
     * Setting Item Selected Listener
     * */
    @OnItemSelected(R.id.simple_spinner)
    public void onSpinnerItemSelected(AdapterView<?> adapterView, View view, int selectedPosition, long itemId)
    {
        if (selectedPosition != 0)
        {
            String selectedItem = adapterView.getItemAtPosition(selectedPosition).toString();
            Toast.makeText(this, selectedItem, Toast.LENGTH_SHORT).show();
        }
    }
}

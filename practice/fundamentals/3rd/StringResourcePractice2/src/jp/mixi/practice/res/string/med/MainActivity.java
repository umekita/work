
package jp.mixi.practice.res.string.med;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.textservice.TextInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements TextWatcher {
    public static final int TEXT_MAX_LENGTH = 100;
    private int mClickCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();

        EditText text = (EditText) findViewById(R.id.TextInput);
        text.addTextChangedListener(this);
    }

    @Override
    protected void onStop() {
        EditText text = (EditText) findViewById(R.id.TextInput);
        text.removeTextChangedListener(this);

        super.onStop();
    }

    @Override
    public void afterTextChanged(Editable s) {}

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        TextView countView = (TextView) findViewById(R.id.TextCounter);
        // TODO: フォーマット用の String リソース（text_counter）を取り出し、setText(CharSequence) の引数に渡す
        countView.setText(getString(R.string.text_counter, ((EditText)findViewById(R.id.TextInput)).getLineCount(), 5));
        //((TextView)findViewById(R.id.TextInput)).getMaxLines()したら
        //Call requires API level 16 (current min is 7): android.widget.TextView#getMaxLines
        //といわれたのでxmlに定義されてた5をそのままかいてみた
    }

    // Show Toast ボタンが押された
    public void onConfirmClick(View v) {
        EditText nameInput = (EditText) findViewById(R.id.NameInput);
        String name = nameInput.getText().toString();
        mClickCount++;
        // TODO: フォーマット用の String リソース（toast_message）を取り出し、makeText(Context, CharSequence, int) の第 2 引数に渡す
        Toast.makeText(this, getString(R.string.toast_message, name, mClickCount), Toast.LENGTH_LONG).show();
    }
}
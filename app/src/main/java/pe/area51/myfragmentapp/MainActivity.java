package pe.area51.myfragmentapp;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends Activity {

    public static final String EXTRA_NOTE_TITLE = "note_title";
    public static final String EXTRA_NOTE_CONTENT = "note_content";

    private final String NOTES_URI ="content://pe.area51.myfragmentapp.NotepadContentProvider/notes";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListFragment.NoteListViewAdapter noteListViewAdapter = ((ListFragment) getFragmentManager().findFragmentById(R.id.activity_main_fragment_list)).getNoteListViewAdapter();
        SQLiteManager sqLiteManager = new SQLiteManager(this);
        getContentResolver().query(Uri.parse(NOTES_URI),);

    }

    @Override
    public void onNoteSelected(final Note note) {
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            ((ContentFragment) getFragmentManager().findFragmentById(R.id.activity_main_fragment_content)).showNote(note);
        } else {
            startActivity(new Intent(this, ContentActivity.class)
                            .putExtra(EXTRA_NOTE_TITLE, note.getTitle())
                            .putExtra(EXTRA_NOTE_CONTENT, note.getContent())
            );
        }
    }
}

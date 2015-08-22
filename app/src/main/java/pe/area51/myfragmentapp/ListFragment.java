package pe.area51.myfragmentapp;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ListFragment extends Fragment {

    private ListView listView;

    private NoteListViewAdapter noteListViewAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        listView = (ListView) getView().findViewById(R.id.fragment_list_listview_list);
        listView.setAdapter(new NoteListViewAdapter(this));

    }



    public  NoteListViewAdapter getNoteListViewAdapter(){
        return noteListViewAdapter;
    }


    public static class NoteListViewAdapter extends ArrayAdapter<Note> {

        private final Fragment fragment;

        public NoteListViewAdapter(final Fragment fragment, final Note[] notes) {
            super(fragment.getActivity(), 0, new ArrayList<Note>());
            this.fragment = fragment;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            final View listElement = fragment.getActivity().getLayoutInflater().inflate(R.layout.fragment_list_listview_element, null);
            final TextView titleTextView = (TextView) listElement.findViewById(R.id.fragment_list_listview_element_title);
            titleTextView.setText(getItem(position).getTitle());
            return listElement;
        }
    }
}

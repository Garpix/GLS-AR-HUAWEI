package fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.activity.OnBackPressedCallback;
import androidx.fragment.app.Fragment;

import com.example.garpixloadsystem.DemoActivity;
import com.example.garpixloadsystem.MainActivity;
import com.example.garpixloadsystem.R;

import java.util.Arrays;

import adapters.CustomBaseAdapter;

public class ExamplesFragment extends Fragment {

    private View view;
    private DemoActivity activity;
    private ListView listView;

    private ExamplesFragment(){}

    public static ExamplesFragment newInstance(){
        return new ExamplesFragment();
    }

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        activity = (DemoActivity) getActivity();

        OnBackPressedCallback callback = new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                Intent intent = new Intent(activity, MainActivity.class);
                startActivity(intent);
            }
        };

        requireActivity().getOnBackPressedDispatcher().addCallback(this, callback);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        view = inflater.inflate(R.layout.fragment_select_example, container,false);

        listView = view.findViewById(R.id.demo_list_view);
        listView.setAdapter(new CustomBaseAdapter(activity, Arrays.asList(getResources().getStringArray(R.array.examples))));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                activity.openFragment(ModeFragment.newInstance(position), R.id.container);
            }
        });

        return view;
    }
}

package fragments;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.example.garpixloadsystem.ARActivity;
import com.example.garpixloadsystem.DemoActivity;
import com.example.garpixloadsystem.R;
import com.example.garpixloadsystem.SceneActivity;

public class ModeFragment extends Fragment {

    private static final int AR_VIEW_REQUEST_CODE = 2;

    private View view;
    private DemoActivity activity;
    private int id;

    private ModeFragment(int id){
        this.id = id;
    }

    public static ModeFragment newInstance(int id){
        return new ModeFragment(id);
    }

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        activity = (DemoActivity) getActivity();
    }

    public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        view = inflater.inflate(R.layout.fragment_select_mode, container,false);

        view.findViewById(R.id.ar_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(activity, Manifest.permission.CAMERA)
                        != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(
                            activity, new String[]{ Manifest.permission.CAMERA }, AR_VIEW_REQUEST_CODE);
                } else {
                    Intent intent = (new Intent(activity, ARActivity.class));
                    intent.putExtra("id", id);
                    startActivity(intent);
                }

            }
        });

        view.findViewById(R.id.scene_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = (new Intent(activity, SceneActivity.class));
                intent.putExtra("id", id);
                startActivity(intent);
            }
        });

        return view;
    }


}

package hortapramesa.horta1.Fragment;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

import hortapramesa.horta1.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FotosTelaInicialFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FotosTelaInicialFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FotosTelaInicialFragment extends Fragment {

    private ImageView imagemTelaInicial;
    private TextView txtTituloFoto;

    public FotosTelaInicialFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fotos_tela_inicial, container, false);

        imagemTelaInicial = (ImageView) view.findViewById(R.id.imagemFragmentFotos);
        txtTituloFoto = (TextView) view.findViewById(R.id.txtTituloFoto);

        txtTituloFoto.setText("logo");

        FirebaseStorage storage = FirebaseStorage.getInstance();
        StorageReference storageReference = storage.getReferenceFromUrl("gs://hortapramesa2017.appspot.com/").child("6 logo.jpg");

        //pegar tamanho da tela do celular

        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        final int height = (displayMetrics.heightPixels - (displayMetrics.heightPixels/2));
        final int width = (displayMetrics.widthPixels - 16);

        final  View view1 = view;
        storageReference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                imagemTelaInicial = (ImageView) view1.findViewById(R.id.imagemFragmentFotos);
                Picasso.with(getContext()).load(uri.toString()).resize(width, height).centerCrop().into(imagemTelaInicial);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

            }
        });
        return view;
    }

}


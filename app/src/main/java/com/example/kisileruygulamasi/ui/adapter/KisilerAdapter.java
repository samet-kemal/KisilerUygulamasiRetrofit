package com.example.kisileruygulamasi.ui.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kisileruygulamasi.R;
import com.example.kisileruygulamasi.data.entity.Kisiler;
import com.example.kisileruygulamasi.databinding.CardTasarimBinding;
import com.example.kisileruygulamasi.ui.fragment.AnasayfaFragmentDirections;
import com.example.kisileruygulamasi.ui.viewmodel.AnasayfaViewModel;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class KisilerAdapter extends RecyclerView.Adapter<KisilerAdapter.CardTasarimTutucu> {
    private Context mContext;
    private List<Kisiler> kisilerListesi;
    private AnasayfaViewModel viewModel;

    public KisilerAdapter(Context mContext, List<Kisiler> kisilerListesi, AnasayfaViewModel viewModel) {
        this.mContext = mContext;
        this.kisilerListesi = kisilerListesi;
        this.viewModel = viewModel;
    }

    public class CardTasarimTutucu extends RecyclerView.ViewHolder {
        private CardTasarimBinding binding;
        public CardTasarimTutucu(CardTasarimBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    @NonNull
    @Override
    public CardTasarimTutucu onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CardTasarimBinding binding =
                DataBindingUtil.inflate(LayoutInflater.from(mContext), R.layout.card_tasarim,parent,false);
        return new CardTasarimTutucu(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CardTasarimTutucu holder, int position) {
        Kisiler kisi = kisilerListesi.get(position);
        CardTasarimBinding t = holder.binding;
        t.setKisiNesnesi(kisi);

        t.satirCard.setOnClickListener(view -> {
            AnasayfaFragmentDirections.KisiDetayGecis gecis =
                    AnasayfaFragmentDirections.kisiDetayGecis(kisi);
            Navigation.findNavController(view).navigate(gecis);
        });

        t.imageViewSil.setOnClickListener(view -> {
            Snackbar.make(view,kisi.getKisi_ad()+" silinsin mi?",Snackbar.LENGTH_LONG)
                    .setAction("EVET",view1 -> {
                        viewModel.sil(kisi.getKisi_id());
                    }).show();
        });
    }

    @Override
    public int getItemCount() {
        return kisilerListesi.size();
    }
}

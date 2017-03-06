package cl.philipsoft.ph1l.wowchar.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cl.philipsoft.ph1l.wowchar.R;
import cl.philipsoft.ph1l.wowchar.adapters.CharacterClickListener;
import cl.philipsoft.ph1l.wowchar.adapters.CharactersAdapter;
import cl.philipsoft.ph1l.wowchar.models.Character;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment implements CharacterClickListener {

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.charactersRv);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());

        recyclerView.setLayoutManager(layoutManager);

        CharactersAdapter charactersAdapter = new CharactersAdapter(this);
        recyclerView.setAdapter(charactersAdapter);
    }

    @Override
    public void clickedId(Long id) {
        Intent intent = new Intent(getActivity(), CharacterDetailsActivity.class);
        intent.putExtra("id", id);
        startActivity(intent);
    }

    @Override
    public void clickedCharacter(Character character) {
        Intent intent = new Intent(getActivity(), CharacterDetailsActivity.class);
        intent.putExtra("Character", character);
        startActivity(intent);
    }
}

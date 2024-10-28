package org.xpapp.userinterface.DeadlineAppication.UI.ListDeadline;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.RecyclerView;

import org.xpapp.userinterface.DeadlineAppication.R;
import org.xpapp.userinterface.DeadlineAppication.databinding.FragmentFirstBinding;

public class ListFragment extends Fragment {

    private FragmentFirstBinding binding;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        ListViewModel listViewModel =
                new ViewModelProvider(this).get(ListViewModel.class);
        listViewModel.setDeadlineAdapterWithContext(this.getContext());

        binding = FragmentFirstBinding.inflate(inflater, container, false);

        View root = binding.getRoot();
        final RecyclerView recyclerView = binding.deadlineRecyclerView;
        listViewModel.getDeadlineAdapter().observe(getViewLifecycleOwner(),
                recyclerView::setAdapter);
        DeadlineAdapter.navController = NavHostFragment.findNavController(this);
        //binding.userRecyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        //binding.userRecyclerView.setAdapter(
        //new UserAdapter(this.getContext(), coachListOfSportsmenViewModel.getUserList()));
        //new UserAdapter(this.getContext(), new ArrayList<>()));
        return root;

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.fab.setOnClickListener(v ->
                NavHostFragment.findNavController(ListFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment)
        );
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}
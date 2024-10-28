package org.xpapp.userinterface.DeadlineAppication.UI.ListDeadline;

import android.os.Build;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import org.xpapp.userinterface.DeadlineAppication.model.Deadline;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ListViewModel extends ViewModel {

    private List<Deadline> deadlineList;
    private MutableLiveData<DeadlineAdapter> mDeadlineAdapter;

    public ListViewModel() {
        deadlineList = new ArrayList<>();
        Deadline deadline = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            deadline = new Deadline("1", OffsetDateTime.now(), 1L);
        }
        deadlineList.add(deadline);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            deadline = new Deadline("2", OffsetDateTime.now(), 2L);
        }
        deadlineList.add(deadline);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            deadline = new Deadline("3", OffsetDateTime.now(), 3L);
        }
        deadlineList.add(deadline);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            deadline = new Deadline("4", OffsetDateTime.now(), 4L);
        }
        deadlineList.add(deadline);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            deadline = new Deadline("5", OffsetDateTime.now(), 5L);
        }
        deadlineList.add(deadline);
    }

    public void setDeadlineAdapterWithContext(android.content.Context context) {
        mDeadlineAdapter = new MutableLiveData<>();
        mDeadlineAdapter.setValue(new DeadlineAdapter(context, deadlineList));
    }

    public MutableLiveData<DeadlineAdapter> getDeadlineAdapter() {
        return mDeadlineAdapter;
    }

}

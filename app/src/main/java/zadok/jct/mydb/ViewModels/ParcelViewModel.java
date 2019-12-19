package zadok.jct.mydb.ViewModels;

import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

import zadok.jct.mydb.Data.ParcelRepository;
import zadok.jct.mydb.Entitties.Parcel;
import zadok.jct.mydb.Utils.postStatus;

public class ParcelViewModel extends ViewModel {
ParcelRepository repository=new ParcelRepository();

public MutableLiveData<postStatus> getStatusMessageViewModel(){
    return repository.getStatusMessageRepository();
}

public void addParcelToRepository(Parcel parcel)
{
    repository.addParcelToDBManger(parcel);
}

    //TODO:

}

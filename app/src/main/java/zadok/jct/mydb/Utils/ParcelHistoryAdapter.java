package zadok.jct.mydb.Utils;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import zadok.jct.mydb.R;

public class ParcelHistoryAdapter extends RecyclerView.Adapter<ParcelHistoryAdapter.ViewHolder> {
    public class

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView parcelTypeTextView;
        public TextView parcelFragileTextView;
        public TextView parcelWeightTextView;
        public TextView parcelWarehouseLocationTextView;
        public TextView parcelRecipientNameTextView;
        public TextView getParcelRecipientAddressTextView;
        public TextView parcelDeliveryDateTextView;
        public TextView parcelReceivingDateTextView;
        public TextView parcelRecipientPhoneTextView;
        public TextView getParcelRecipientEmailTextView;
        public TextView parcelStatusTextView;
        public TextView parcelCarrierNameTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            parcelTypeTextView=itemView.findViewById(R.id.parcel_type_his);
            parcelFragileTextView=itemView.findViewById(R.id.fragile_content_his);
            parcelWeightTextView=itemView.findViewById(R.id.parcel_wheight_his);
            parcelWarehouseLocationTextView=itemView.findViewById(R.id.parcel_warehouse_location_his);
            parcelRecipientNameTextView=itemView.findViewById(R.id.parcel_recipient_name_his);
            getParcelRecipientAddressTextView=itemView.findViewById(R.id.parcel_recipient_address_his);
            parcelDeliveryDateTextView=itemView.findViewById(R.id.delivery_date_his);
            parcelReceivingDateTextView=itemView.findViewById(R.id.parcel_delivery_date_his);
            parcelRecipientPhoneTextView=itemView.findViewById(R.id.recipient_phone_his);
            getParcelRecipientEmailTextView=itemView.findViewById(R.id.recipient_email_his);
            parcelStatusTextView=itemView.findViewById(R.id.parcel_status_his);
            parcelCarrierNameTextView=itemView.findViewById(R.id.parcel_carrier_name_his);


        }
    }
}

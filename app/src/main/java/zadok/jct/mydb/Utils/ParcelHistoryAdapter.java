package zadok.jct.mydb.Utils;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import zadok.jct.mydb.R;

public class ParcelHistoryAdapter extends RecyclerView.Adapter<ParcelHistoryAdapter.ViewHolder> {

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView parcelIdTextView;
        public TextView parcelRecipientNameTextView;
        public TextView parcelRecipientPhoneTextView;
        public TextView ParcelRecipientAddressTextView;
        /*
        public TextView parcelTypeTextView;
        public TextView parcelFragileTextView;
        public TextView parcelWeightTextView;
        public TextView parcelWarehouseLocationTextView;
        public TextView parcelReceivingDateTextView;
        public TextView getParcelRecipientEmailTextView;
        public TextView parcelStatusTextView;
        public TextView parcelCarrierNameTextView;*/



        /**
         * @param itemView
         */
        public ViewHolder(@NonNull TextView itemView) {
            super(itemView);

            parcelRecipientNameTextView = itemView.findViewById(R.id.recipient_name_his);
            ParcelRecipientAddressTextView = itemView.findViewById(R.id.recipient_address_his);
            parcelIdTextView = itemView.findViewById(R.id.parcel_Id_his);
            parcelRecipientPhoneTextView = itemView.findViewById(R.id.recipient_phone_his);
            /*parcelTypeTextView = itemView;
            parcelFragileTextView = itemView.findViewById(R.id.fragile_content_his);
            parcelWeightTextView = itemView.findViewById(R.id.parcel_wheight_his);
            parcelWarehouseLocationTextView = itemView.findViewById(R.id.parcel_warehouse_location_his);
            parcelReceivingDateTextView = itemView.findViewById(R.id.parcel_delivery_date_his);
            getParcelRecipientEmailTextView = itemView.findViewById(R.id.recipient_email_his);
            parcelStatusTextView = itemView.findViewById(R.id.parcel_status_his);
            parcelCarrierNameTextView = itemView.findViewById(R.id.parcel_carrier_name_his);*/
        }
    }

    private List<String[]> parcelList;

    public ParcelHistoryAdapter(List<String[]> ParcelList) {

        parcelList = ParcelList;
    }

    @NonNull
    @Override
    public ParcelHistoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        /*Context myContext = parent.getContext();
        LayoutInflater myInflater = LayoutInflater.from(myContext);

        //Inflate the custom layout
        View parcelRowView = myInflater.inflate(R.layout.recycler_view_row, parent, false);
        */

        TextView parcelRowView=(TextView)LayoutInflater.
                from(parent.getContext()).inflate(R.layout.recycler_view_row,parent,false) ;

        //Return a new holder instance
        ViewHolder myViewHolder = new ViewHolder(parcelRowView);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ParcelHistoryAdapter.ViewHolder myViewHolder, int position) {
        //Get the data model based on position
        String[] thisParcel = parcelList.get(position);

        //Set Item views
        myViewHolder.parcelIdTextView.setText(thisParcel[0]);
        myViewHolder.parcelRecipientNameTextView.setText(thisParcel[1]);
        myViewHolder.ParcelRecipientAddressTextView.setText(thisParcel[2]);
        myViewHolder.parcelRecipientPhoneTextView.setText(thisParcel[3]);

        /*TextView textFragileView = myViewHolder.parcelFragileTextView;
        String fragile;
        if (thisParcel.getFragile()) {
            fragile = "Fragile";
        } else {
            fragile = "Not Fragile";
        }
        textFragileView.setText(fragile);
        TextView textWeightView = myViewHolder.parcelWeightTextView;
        textWeightView.setText(thisParcel.getWeight().toString());
        TextView textWLocationView = myViewHolder.parcelWarehouseLocationTextView;
        textWLocationView.setText(thisParcel.getTargetLocation().toString());
        TextView textRNameView = myViewHolder.parcelRecipientNameTextView;
        textRNameView.setText(thisParcel.getName());
        TextView textRAddressView = myViewHolder.getParcelRecipientAddressTextView;
        textRAddressView.setText(thisParcel.getInhibitorAddress().toString());
        //TextView textDDateView = myViewHolder.parcelDeliveryDateTextView;
        //textDDateView.setText(thisParcel.get);
        TextView textRDateView = myViewHolder.parcelReceivingDateTextView;
        textRDateView.setText(thisParcel.getCameToInhibitorTime().toString());
        TextView textRPhoneView = myViewHolder.parcelRecipientPhoneTextView;
        textRPhoneView.setText(thisParcel.getPhoneNumber());
        TextView textRMailView = myViewHolder.getParcelRecipientEmailTextView;
        textRMailView.setText(thisParcel.getMail());
        TextView textStatusView = myViewHolder.parcelStatusTextView;
        textStatusView.setText(thisParcel.getStatus().toString());
        TextView textCNameView = myViewHolder.parcelCarrierNameTextView;
        textCNameView.setText(thisParcel.getMessengerName());*/
    }


    @Override
    public int getItemCount() {
        return parcelList.size();
    }




}

package zadok.jct.mydb.Utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import zadok.jct.mydb.Entitties.Parcel;
import zadok.jct.mydb.R;

public class ParcelHistoryAdapter extends RecyclerView.Adapter<ParcelHistoryAdapter.ViewHolder> {

    ViewHolder myViewHolder;
    private List<Parcel> parcelList;

    public ParcelHistoryAdapter(List<Parcel> ParcelList) {
        parcelList = ParcelList;
    }

    @NonNull
    @Override
    public ParcelHistoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context myContext = parent.getContext();
        LayoutInflater myInflater = LayoutInflater.from(myContext);

        //Inflate the custom layout
        View parcelRowView = myInflater.inflate(R.layout.recycler_view_row, parent, false);


        //Return a new holder instance
        myViewHolder = new ViewHolder(parcelRowView);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ParcelHistoryAdapter.ViewHolder myViewHolder, int position) {
        //Get the data modelbased on position
        Parcel thisParcel = parcelList.get(position);

        //Set Item views
        TextView textTypeView = myViewHolder.parcelTypeTextView;
        textTypeView.setText(thisParcel.getType().toString());
        TextView textFragileView = myViewHolder.parcelFragileTextView;
        String fragile;
        if (thisParcel.getFragile()) {
            fragile = "Fragile";
        } else {fragile = "Not Fragile";}
        textFragileView.setText(fragile);
        TextView textWeightView = myViewHolder.parcelWeightTextView;
        textWeightView.setText(thisParcel.getWeight().toString());
        TextView textWLocationView = myViewHolder.parcelWarehouseLocationTextView;
        textWLocationView.setText(thisParcel.getTargetLocation().toString());
        TextView textRNameView = myViewHolder.parcelRecipientNameTextView;
        textRNameView.setText(thisParcel.getName());
        TextView textRAddressView = myViewHolder.getParcelRecipientAddressTextView;
        textRAddressView.setText(thisParcel.getInhibitorAddress().toString());
        TextView textDDateView = myViewHolder.parcelDeliveryDateTextView;
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
        textCNameView.setText(thisParcel.getMessengerName());
    }


    @Override
    public int getItemCount() {
        return 0;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView parcelTypeTextView;
        TextView parcelFragileTextView;
        TextView parcelWeightTextView;
        TextView parcelWarehouseLocationTextView;
        TextView parcelRecipientNameTextView;
        TextView getParcelRecipientAddressTextView;
        TextView parcelDeliveryDateTextView;
        TextView parcelReceivingDateTextView;
        TextView parcelRecipientPhoneTextView;
        TextView getParcelRecipientEmailTextView;
        TextView parcelStatusTextView;
        TextView parcelCarrierNameTextView;

        /**
         * @param itemView
         */
        ViewHolder(@NonNull View itemView) {
            super(itemView);
            parcelTypeTextView = itemView.findViewById(R.id.parcel_type_his);
            parcelFragileTextView = itemView.findViewById(R.id.fragile_content_his);
            parcelWeightTextView = itemView.findViewById(R.id.parcel_wheight_his);
            parcelWarehouseLocationTextView = itemView.findViewById(R.id.parcel_warehouse_location_his);
            parcelRecipientNameTextView = itemView.findViewById(R.id.parcel_recipient_name_his);
            getParcelRecipientAddressTextView = itemView.findViewById(R.id.parcel_recipient_address_his);
            parcelDeliveryDateTextView = itemView.findViewById(R.id.delivery_date_his);
            parcelReceivingDateTextView = itemView.findViewById(R.id.parcel_delivery_date_his);
            parcelRecipientPhoneTextView = itemView.findViewById(R.id.recipient_phone_his);
            getParcelRecipientEmailTextView = itemView.findViewById(R.id.recipient_email_his);
            parcelStatusTextView = itemView.findViewById(R.id.parcel_status_his);
            parcelCarrierNameTextView = itemView.findViewById(R.id.parcel_carrier_name_his);


        }
    }
}

package com.example.testdbentity.homefragment.bookinghotel.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testdbentity.R;
import com.example.testdbentity.homefragment.bookinghotel.image.roomandimg.RoomWithImage;

import java.util.List;

public class ItemRAdapter extends RecyclerView.Adapter<ItemRAdapter.ItemRHolder> {
    List<RoomWithImage> roomWithImageList;
    OnClickRoom onClickRoom;
    public ItemRAdapter(List<RoomWithImage> roomWithImageList) {
        this.roomWithImageList = roomWithImageList;
    }
    public void setOnClickRoom(OnClickRoom onClickRoom)
    {
        this.onClickRoom = onClickRoom;
    }

    public void setData(List<RoomWithImage> roomWithImageList)
    {
        this.roomWithImageList = roomWithImageList;
    }
    @NonNull
    @Override
    public ItemRHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_r, parent, false);
        return new ItemRHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemRHolder holder, int position) {
        RoomWithImage roomWithImage = roomWithImageList.get(position);

        holder.imageView.setImageResource(roomWithImage.imageRooms.get(0).srcImageRoom);
        holder.nameH.setText(roomWithImage.bookingRoomEntity.nameBookingRoom);
        holder.addressH.setText(roomWithImage.bookingRoomEntity.notiBookingHotel);
        holder.priceH.setText(roomWithImage.bookingRoomEntity.priceBookingRoom);
        holder.save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickRoom.onSaveRoom(roomWithImage.bookingRoomEntity.idBookingRoom, roomWithImage.bookingRoomEntity.fkBookingRoom);
            }
        });
        holder.book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickRoom.onBookRoom(roomWithImage.bookingRoomEntity.idBookingRoom, roomWithImage.bookingRoomEntity.fkBookingRoom);
            }
        });
    }

    @Override
    public int getItemCount() {
        return roomWithImageList.size();
    }

    public class ItemRHolder extends RecyclerView.ViewHolder{
        private ImageView imageView;
        private TextView nameH;
        private TextView addressH;
        private TextView priceH;
        private Button save;
        private Button book;
        public ItemRHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_r);
            nameH = itemView.findViewById(R.id.name_r);
            addressH = itemView.findViewById(R.id.address_r);
            priceH = itemView.findViewById(R.id.price_r);
            save = itemView.findViewById(R.id.save_r);
            book = itemView.findViewById(R.id.book_r);
        }
    }
}

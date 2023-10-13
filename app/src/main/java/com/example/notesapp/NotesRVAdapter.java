package com.example.notesapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class NotesRVAdapter extends RecyclerView.Adapter<NotesRVAdapter.NoteViewHolder> {
    private List<Note> arrNotes = new ArrayList<>();
    private OnItemClickListener listener;


    public class NoteViewHolder extends RecyclerView.ViewHolder{
        private TextView titleText, contentText;

        public NoteViewHolder(View itemView){
            super(itemView);
            titleText=itemView.findViewById(R.id.titleText);
            contentText=itemView.findViewById(R.id.contentText);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if(listener != null && position!=RecyclerView.NO_POSITION){
                        listener.onItemClick(arrNotes.get(position));
                    }
                }
            });
        }

    }

    public NoteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.note_row, parent, false);
        return new NoteViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, int position) {
        Note currentNote = arrNotes.get(position);
        holder.titleText.setText(currentNote.getTitle());
        holder.contentText.setText(currentNote.getContent());
    }

    @Override
    public int getItemCount() {
        return arrNotes.size();
    }

   public void setNotes(List<Note> arrNotes){
        this.arrNotes= arrNotes;
        notifyDataSetChanged();
   }

   public Note getNoteAt(int position){
        return arrNotes.get(position);
    }


    public interface OnItemClickListener{
        void onItemClick(Note note);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        this.listener=listener;
    }
}



package com.example.boardporject.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.boardporject.BoardVH;
import com.example.boardporject.R;
import com.example.boardporject.model.BoardDO;

import java.util.ArrayList;
import java.util.List;

public class BoardListAdapter extends RecyclerView.Adapter<BoardVH> {

    private static final String TAG = "BoardListAdapter";
    private BoardVH.OnItemClickEventListener onItemClickListener;
    private final List<BoardDO> items = new ArrayList<>();

    @NonNull
    @Override
    public BoardVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_board_list_item, parent, false);
        return new BoardVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BoardVH holder, int position) {
        holder.bind(items.get(position));
        if(onItemClickListener != null) holder.setOnItemClickListener(onItemClickListener);
    }

    public void set(List<BoardDO> $data) {
        items.clear();
        items.addAll($data);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void setOnItemClickListener(BoardVH.OnItemClickEventListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
}

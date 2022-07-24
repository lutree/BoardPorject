package com.example.boardporject;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.boardporject.adapter.BoardListAdapter;
import com.example.boardporject.model.BoardDO;

public class BoardVH extends RecyclerView.ViewHolder {

    private TextView text_board_seq, text_write_time, text_board_writer, text_board_subject;

    private OnItemClickEventListener onItemClickListener;

    public BoardVH(@NonNull View itemView) {
        super(itemView);
        text_board_seq = itemView.findViewById(R.id.text_board_seq);
        text_write_time = itemView.findViewById(R.id.text_write_time);
        text_board_writer = itemView.findViewById(R.id.text_board_writer);
        text_board_subject = itemView.findViewById(R.id.text_board_subject);
    }

    public void bind(BoardDO $data) {

        text_board_seq.setText(String.valueOf($data.getBoard_seq()));

        if ($data.getDel_yn().equals("Y")) {
            text_write_time.setText("");
            text_board_writer.setText("");
            text_board_subject.setText(itemView.getResources().getText(R.string.board_delete));
        } else {
            text_write_time.setText($data.getUpd_date());
            text_board_writer.setText($data.getBoard_writer());
            text_board_subject.setText($data.getBoard_subject());
        }

        itemView.setOnClickListener(view -> {
            if (onItemClickListener != null && $data.getDel_yn().equals("N"))
                onItemClickListener.onItemClick($data.getBoard_seq());
        });
    }

    public void setOnItemClickListener(OnItemClickEventListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickEventListener {
        void onItemClick(int boardSeq);
    }
}

package com.example.boardporject.model;

import com.google.gson.annotations.JsonAdapter;

import java.io.Serializable;

public class BoardDO implements Serializable {
    private String board_content; //    string              게시글의 내용 VARCHAR(2000)
    private Integer board_hits; // 	    integer($int32)     게시글의 조회수
    private Integer board_re_lev; //	integer($int32)     게시글 답변 글의 깊이
    private Integer board_re_ref; //    integer($int32)     게시글 그룹 번호
    private Integer board_re_seq; //    integer($int32)     게시글 답변 글의 순서
    private Integer board_seq; //       integer($int32)     게시글 번호
    private String board_subject; //    string              게시글의 제목 VARCHAR(50)
    private String board_writer; //     string              게시글의 작성자 VARCHAR(20)
    private String del_yn; //           string              게시글 삭제 유무
    private String ins_date; //         string              게시글 입력 일시
    private String ins_user_id; //      string              게시글 입력자 ID
    private String upd_date; //         string              게시글 수정 일시
    private String upd_user_id; //      string              게시글 수정자 ID

    public String getBoard_content() {
        return board_content;
    }

    public void setBoard_content(String board_content) {
        this.board_content = board_content;
    }

    public Integer getBoard_hits() {
        return board_hits;
    }

    public void setBoard_hits(Integer board_hits) {
        this.board_hits = board_hits;
    }

    public Integer getBoard_re_lev() {
        return board_re_lev;
    }

    public void setBoard_re_lev(Integer board_re_lev) {
        this.board_re_lev = board_re_lev;
    }

    public Integer getBoard_re_ref() {
        return board_re_ref;
    }

    public void setBoard_re_ref(Integer board_re_ref) {
        this.board_re_ref = board_re_ref;
    }

    public Integer getBoard_re_seq() {
        return board_re_seq;
    }

    public void setBoard_re_seq(Integer board_re_seq) {
        this.board_re_seq = board_re_seq;
    }

    public Integer getBoard_seq() {
        return board_seq;
    }

    public void setBoard_seq(Integer board_seq) {
        this.board_seq = board_seq;
    }

    public String getBoard_subject() {
        return board_subject;
    }

    public void setBoard_subject(String board_subject) {
        this.board_subject = board_subject;
    }

    public String getBoard_writer() {
        return board_writer;
    }

    public void setBoard_writer(String board_writer) {
        this.board_writer = board_writer;
    }

    public String getDel_yn() {
        return del_yn;
    }

    public void setDel_yn(String del_yn) {
        this.del_yn = del_yn;
    }

    public String getIns_date() {
        return ins_date;
    }

    public void setIns_date(String ins_date) {
        this.ins_date = ins_date;
    }

    public String getIns_user_id() {
        return ins_user_id;
    }

    public void setIns_user_id(String ins_user_id) {
        this.ins_user_id = ins_user_id;
    }

    public String getUpd_date() {
        return upd_date;
    }

    public void setUpd_date(String upd_date) {
        this.upd_date = upd_date;
    }

    public String getUpd_user_id() {
        return upd_user_id;
    }

    public void setUpd_user_id(String upd_user_id) {
        this.upd_user_id = upd_user_id;
    }

    @Override
    public String toString() {
        return "BoardDO{" +
                "board_content='" + board_content + '\'' +
                ", board_hits=" + board_hits +
                ", board_re_lev=" + board_re_lev +
                ", board_re_ref=" + board_re_ref +
                ", board_re_seq=" + board_re_seq +
                ", board_seq=" + board_seq +
                ", board_subject='" + board_subject + '\'' +
                ", board_writer='" + board_writer + '\'' +
                ", del_yn='" + del_yn + '\'' +
                ", ins_date='" + ins_date + '\'' +
                ", ins_user_id='" + ins_user_id + '\'' +
                ", upd_date='" + upd_date + '\'' +
                ", upd_user_id='" + upd_user_id + '\'' +
                '}';
    }
}

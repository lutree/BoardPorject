package com.example.boardporject.model;

public class BoardFilesDO {
    private Integer board_seq; //   	integer($int32)     게시글 번호
    private String del_yn;  //      	string              첨부파일 삭제 유무
    private String file_name;//      	string              첨부파일명
    private String file_name_key;// 	string              첨부파일 암호화명
    private Integer file_no;//      	integer($int32)     첨부파일 번호
    private String file_path;//     	string              첨부파일 경로
    private String file_size;       //	string              첨부파일 크기
    private String ins_date;        //  string              첨부파이 입력 일시
    private String ins_user_id;     //	string              첨부파일 입력자 ID
    private String remark;          //	string              비고
    private String upd_date;        //	string              첨부파일 수정 일시
    private String upd_user_id;     //	string              첨부파일 수정자 ID

    public Integer getBoard_seq() {
        return board_seq;
    }

    public void setBoard_seq(Integer board_seq) {
        this.board_seq = board_seq;
    }

    public String getDel_yn() {
        return del_yn;
    }

    public void setDel_yn(String del_yn) {
        this.del_yn = del_yn;
    }

    public String getFile_name() {
        return file_name;
    }

    public void setFile_name(String file_name) {
        this.file_name = file_name;
    }

    public String getFile_name_key() {
        return file_name_key;
    }

    public void setFile_name_key(String file_name_key) {
        this.file_name_key = file_name_key;
    }

    public Integer getFile_no() {
        return file_no;
    }

    public void setFile_no(Integer file_no) {
        this.file_no = file_no;
    }

    public String getFile_path() {
        return file_path;
    }

    public void setFile_path(String file_path) {
        this.file_path = file_path;
    }

    public String getFile_size() {
        return file_size;
    }

    public void setFile_size(String file_size) {
        this.file_size = file_size;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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
}

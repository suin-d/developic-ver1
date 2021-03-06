package com.dia.profile.model.service;

import static com.dia.common.JDBCTemplate.close;
import static com.dia.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import com.dia.photo.model.vo.PhotoInsert;
import com.dia.profile.model.dao.ProfileDao;
import com.dia.profile.model.vo.Picstorys;
import com.dia.user.model.vo.User;

public class ProfileService {
	
	/**
	 * 작가 프로필 페이지의 상단에 띄워줄 해당 작가 정보를 조회해오는 메소드 
	 * @param userNo
	 * @return
	 */
	public User selectUser(int userNo){
		
		Connection conn = getConnection();
		
		User u = new ProfileDao().selectUser(conn, userNo);
		
		close(conn);
		
		return u;
		
	}
	
	/**
	 * profile 페이지 하단 allpost에 뿌려줄 해당 user의 사진들을 조회해오는 메소드
	 * @param userNo
	 * @return
	 */
	public ArrayList<PhotoInsert> selectPhotos(int userNo){
		
		Connection conn = getConnection();
		
		
		ArrayList<PhotoInsert> photoList = new ProfileDao().selectPhotos(conn, userNo);
		
		close(conn);		
		
		return photoList;
		
	}
	
	/**
	 * 해당 작가의 picstory 리스트 조회해오는 메소드
	 * @param userNo	어떤 작가의 picstory인지 해당 유저의 userNo
	 * @return
	 */
	public ArrayList<Picstorys> selectPicList(int userNo){
		
		Connection conn = getConnection();
		
		ArrayList<Picstorys> picList = new ProfileDao().selectPicList(conn, userNo);
		
		close(conn);
		
		return picList;
		
	}
	
	/**
	 * 해당 Picstory_ID 를 가진 픽스토리의 썸네일 조회해오는 메소드
	 * @param picId
	 * @return
	 */
	public Picstorys selectPicThumbnail(int picId) {
		
		Connection conn = getConnection();
		
		Picstorys p = new ProfileDao().selectPicThumbnail(conn, picId);
		
		close(conn);
		
		return p;
	}
	
	/**
	 * 해당 userNo을 가진 작가의, picId를 가진 픽스토리 내에 등록되어있는 사진만을 조회해오는 메소드
	 * @param userNo
	 * @param picId
	 * @return
	 */
	public ArrayList<PhotoInsert> selectPicPhoto(int userNo, int picId){
		
		Connection conn = getConnection();
		
		ArrayList<PhotoInsert> picPhoto = new ProfileDao().selectPicPhoto(conn, userNo, picId);
		
		close(conn);
		
		return picPhoto;
		
	}

}

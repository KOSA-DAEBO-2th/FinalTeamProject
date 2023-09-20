package kr.co.hit.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.hit.dao.LectureDao;
import kr.co.hit.dao.MeetingDao;
import kr.co.hit.dto.LectureDto;
import kr.co.hit.dto.MeetingDto;

@Service
public class LectureService implements LectureDao {

	@Autowired
	private SqlSession sqlsession;
	
	@Override
	public int getLectureListCount(String search_target, String topic) {
		LectureDao dao = sqlsession.getMapper(LectureDao.class);
		return dao.getLectureListCount(search_target ,topic);
	}

	@Override
	public List<LectureDto> selectLecturePage(String search_target, int start, int limit) {
		LectureDao dao = sqlsession.getMapper(LectureDao.class);
		List<LectureDto> list = dao.selectLecturePage(search_target, start, limit);
		return list;
	}
	
	@Override
	public List<LectureDto> selectLectureTopicList(String search_target, String topic, int start, int limit) {
		LectureDao dao = sqlsession.getMapper(LectureDao.class);
		List<LectureDto> list = dao.selectLectureTopicList(search_target, topic, start, limit );
		return list;
	}

	@Override
	public List<LectureDto> selectLectureList() {
		LectureDao dao = sqlsession.getMapper(LectureDao.class);
		List<LectureDto> list = dao.selectLectureList();
		return list;
	}

	@Override
	public void increaseView(int boardIdx) {
		LectureDao dao = sqlsession.getMapper(LectureDao.class);
		dao.increaseView(boardIdx);		
	}	
	
	@Override
	public LectureDto selectLectureRead(int boardIdx) {
		LectureDao dao = sqlsession.getMapper(LectureDao.class);
		LectureDto list = dao.selectLectureRead(boardIdx);
		return list;
	}

	
}

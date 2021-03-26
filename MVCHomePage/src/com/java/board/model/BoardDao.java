package com.java.board.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import com.java.database.ConnectionProvider;
import com.java.database.JdbcUtil;

public class BoardDao {
	
	public static BoardDao instance = new BoardDao();
	
	
	public static BoardDao getInstance() {
		return instance;
	}
	
	
	public int insert(BoardDto boardDto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int value =0;
		
		writeNumber(boardDto,conn);
		
		try {
			String sql = "insert into board(board_number,writer,subject,"
					+"email,content,password,write_date,read_count,"
					+"group_number,sequence_number,sequence_level,file_name,path,file_size)"
					+"values(board_number_seq.nextval,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardDto.getWriter());
			pstmt.setString(2, boardDto.getSubject());
			pstmt.setString(3, boardDto.getEmail());
			//Todo : replace함수는 함정이 있음 꼭 찾아보기!
			pstmt.setString(4, boardDto.getContent().replace("\r\n", "<br>"));
			pstmt.setString(5, boardDto.getPassword());
			pstmt.setTimestamp(6,new Timestamp(boardDto.getWriteDate().getTime()));
			pstmt.setInt(7, boardDto.getReadCount());
			pstmt.setInt(8, boardDto.getGroupNumber());
			pstmt.setInt(9, boardDto.getSequenceNumber());
			pstmt.setInt(10, boardDto.getSequenceLevel());
			
			pstmt.setString(11,boardDto.getFileName());
			pstmt.setString(12,boardDto.getPath());
			pstmt.setLong(13,boardDto.getFileSize());
			
			value=pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
		}
		
		return value;
	}
	
	
	public void writeNumber(BoardDto boardDto, Connection conn) {
		
		//그룹번호생성, 글순서(자식), 글레벨(자식) - 답변의 경우
		
		int boardNumber = boardDto.getBoardNumber();
		int groupNumber = boardDto.getGroupNumber();
		int sequenceNumber = boardDto.getSequenceNumber();
		int sequenceLevel = boardDto.getSequenceLevel();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = null;
		try {
			if(boardNumber==0) { // 부모글의 그룹번호
				sql = "select max(group_number) from board";
				conn = ConnectionProvider.getConnection();
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					int max = rs.getInt(1);
					boardDto.setGroupNumber(max+1);
				}
			}else {
				//답글: 글 순서, 글레벨 세팅
				sql = "update board set sequence_number = sequence_number+1"+
						"where group_number=? and sequence_number>?";
				
				conn = ConnectionProvider.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, groupNumber);
				pstmt.setInt(2, sequenceNumber);
				pstmt.executeUpdate();
				
				sequenceNumber = sequenceNumber+1;
				sequenceLevel = sequenceLevel+1;
				
				boardDto.setSequenceNumber(sequenceNumber);
				boardDto.setSequenceLevel(sequenceLevel);
				
				
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
		}
		
	}


	public int getCount() {
		int value=0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			String sql = "select count(*) from board";
			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				value = rs.getInt(1);
				
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
		}
		
		return value;
	}


	public ArrayList<BoardDto> getBoardList(int startRow, int endRow) {
		
		ArrayList<BoardDto> boardList = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			String sql="select * "
					+"from ( "
					+"select rownum as rnum, a.* "
					+"from ( "
					+"select * "
					+"from board "
					+"order by group_number desc, sequence_number asc"
					+") a "
					+") b "
					+"where b.rnum >=? and b.rnum <=?";
					
			
			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			
			boardList = new ArrayList<BoardDto>();
			rs = pstmt.executeQuery();
			while (rs.next()) {
				BoardDto boardDto = new BoardDto();
				boardDto.setBoardNumber(rs.getInt("board_number"));
				boardDto.setWriter(rs.getString("writer"));
				boardDto.setSubject(rs.getString("subject"));
				boardDto.setEmail(rs.getString("email"));
				boardDto.setContent(rs.getString("content"));
				boardDto.setPassword(rs.getString("password"));
				boardDto.setWriteDate(new Date(rs.getTimestamp("write_date").getTime()));
				boardDto.setReadCount(rs.getInt("read_count"));
				boardDto.setGroupNumber(rs.getInt("group_number"));
				boardDto.setSequenceNumber(rs.getInt("sequence_number"));
				boardDto.setSequenceLevel(rs.getInt("sequence_level"));
				
				boardList.add(boardDto);
				
			}
			
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
		}
		
		return boardList;
		
	}


	public BoardDto read(int boardNumber) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BoardDto boardDto = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			
			String sqlUpdate = "Update board set read_count=read_count+1"
					+" where board_number=?";
			
			pstmt = conn.prepareStatement(sqlUpdate);
			pstmt.setInt(1, boardNumber);
			
			int value=pstmt.executeUpdate();
			
			if(value>0) {
				
				String sqlSelect = "select * from board where board_number=?";
				pstmt=conn.prepareStatement(sqlSelect);
				pstmt.setInt(1, boardNumber);
				rs=pstmt.executeQuery();
				if(rs.next()) {
					boardDto = new BoardDto();
					boardDto.setBoardNumber(rs.getInt("board_number"));
					boardDto.setWriter(rs.getString("writer"));
					boardDto.setSubject(rs.getString("subject"));
					boardDto.setEmail(rs.getString("email"));
					boardDto.setContent(rs.getString("content"));
					boardDto.setPassword(rs.getString("password"));
					boardDto.setWriteDate(new Date(rs.getTimestamp("write_date").getTime()));
					boardDto.setReadCount(rs.getInt("read_count"));
					boardDto.setGroupNumber(rs.getInt("group_number"));
					boardDto.setSequenceLevel(rs.getInt("sequence_level"));
					boardDto.setSequenceNumber(rs.getInt("sequence_number"));
					boardDto.setFileName(rs.getString("file_name"));
					boardDto.setFileSize(rs.getLong("file_size"));
					boardDto.setPath(rs.getString("path"));
					
				}
				conn.commit();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			JdbcUtil.rollback(conn);
		}finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
		}
		return boardDto;
	}

	
	public int update(BoardDto boardDto) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		int value = 0;
		try {
			
			String sql = "update board set subject=?,email=?,content=?,password=?,write_date=? where board_number=?";
			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			
			pstmt.setString(1,boardDto.getSubject());
			pstmt.setString(2,boardDto.getEmail());
			pstmt.setString(3,boardDto.getContent());
			pstmt.setString(4,boardDto.getPassword());
			pstmt.setTimestamp(5,new Timestamp(boardDto.getWriteDate().getTime()));
			pstmt.setInt(6,boardDto.getBoardNumber());
			
			value=pstmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
		}
		
		return value;
	}


	public int delete(int boardNumber) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		int value =0;
		try {
			String sql = "delete from board where board_number=?";
			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, boardNumber);
			
			value=pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
		}
		return value;
	}
}

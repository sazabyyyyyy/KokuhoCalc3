package mrs.domain.model;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

/**
 * @author Takuya Kaneko
 * ReservableRoomエンティティ
 *
 *
 *
 */
@Entity
public class ReservableRoom  implements Serializable{

	//複合キーを扱うためのアノテーション
	@EmbeddedId
	private ReservableRoomId reservableRoomId;


	//MeetingRoomエンティティと一方向の多対1の関連設定を行う。外部キーとしてroom_idを指定する。
	@ManyToOne
	@JoinColumn(name="room_id",insertable=false,updatable=false)


	//複合クラスのうち外部キーとして使うフィールド名を指定する。
	@MapsId("roomid")
	private MeetingRoom meetingRoom;

    public ReservableRoom(ReservableRoomId reservableRoomid) {
    	this.reservableRoomId=reservableRoomid;
    }

    public  ReservableRoom() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public ReservableRoomId getReservableRoomId() {
		return reservableRoomId;
	}

	public void setReservableRoomId(ReservableRoomId reservableRoomId) {
		this.reservableRoomId = reservableRoomId;
	}

	public MeetingRoom getMeetingRoom() {
		return meetingRoom;
	}

	public void setMeetingRoom(MeetingRoom meetingRoom) {
		this.meetingRoom = meetingRoom;
	}



}

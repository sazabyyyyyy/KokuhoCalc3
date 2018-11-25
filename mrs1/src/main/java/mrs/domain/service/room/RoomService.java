package mrs.domain.service.room;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mrs.domain.model.ReservableRoom;
import mrs.domain.repository.room.ReservableRoomRepository;

//サービスクラスとして扱う
@Service
//このクラスの各メソッドが自動でトランザクションを管理されるようにする
@Transactional
public class RoomService {

	//インジェクションする
	@Autowired
	ReservableRoomRepository reservableRoomRepository;

	public List<ReservableRoom> findReservableRooms(LocalDate date){
		//メソッドを呼び出す
		return reservableRoomRepository.findByReservableRoomId_reservedDateOrderByReservableRoomId_roomIdAsc(date);
	}

}

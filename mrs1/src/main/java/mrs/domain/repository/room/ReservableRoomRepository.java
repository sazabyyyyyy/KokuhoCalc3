package mrs.domain.repository.room;


import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import mrs.domain.model.ReservableRoom;
import mrs.domain.model.ReservableRoomId;

/**
 * @author Takuya Kaneko
 *
 *Jpaインターフェースを継承してエンティティ用のリポジトリインターフェイスを作成する
 *
 *指定日に予約可能な会議室の一覧を取得するメソッドを定義する。SpringData　JPAの命名規約でメソッド名を作成する。
 *
 */
public interface ReservableRoomRepository extends JpaRepository<ReservableRoom,ReservableRoomId> {
	List<ReservableRoom> findByReservableRoomId_reservedDateOrderByReservableRoomId_roomIdAsc(LocalDate reservedDate);

}

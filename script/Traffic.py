from locust import HttpUser, task, constant
import threading

class WaitingRoomUser(HttpUser):
    wait_time = constant(1.0)  # 요청 간 간격을 1초로 고정

    # 클래스 변수로 user_id와 락 정의
    user_id_counter = 1
    user_id_lock = threading.Lock()

    def get_next_user_id(self):
        with self.user_id_lock:
            user_id = WaitingRoomUser.user_id_counter
            WaitingRoomUser.user_id_counter += 1
            return user_id

    @task
    def enter_waiting_room(self):
        user_id = self.get_next_user_id()
        params = {
            "user_id": user_id,
            "redirect_url": "http://127.0.0.1:9000"
        }
        self.client.get("/waiting-room", params=params, name="/waiting-room")

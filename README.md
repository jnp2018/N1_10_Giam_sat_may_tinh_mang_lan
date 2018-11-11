# N1_10_Giam_sat_may_tinh_mang_lan
Công cụ giám sát máy tính trong mạng Lan 

Project netbean này đã đc tách thành 2 phần riêng biệt để dễ theo dõi và chạy:



 - Phần 1 gôm 4 chức năng chínChuowlass main chạy cả 4 chưc năng nằm ở class LapTrinhMang , bạn có thể chạy luôn chương trình ở class này):
    + Thực hiện theo dõi coppy pate (Class Coppypate): ở đây bạn thay thế nơi lưu file trong trường COPIED_FILES_PATH , và nơi lưu logtext tại trường COPIED_STRING_PATH,  cần thay đổi cả đường dẫn tại dòng 125, và 167
    + Thực hiện theo dõi bàn phim (Class KeyLoggerClient): Tại đây bạn cần thay đường dẫn lưu file log tại dòng 376
    + Thực hiện chặn ứng dụng bị caams (class BlockApp): ở đây bạn cần tạo đường dẫn tới file liệt kê các app bị block tại dòng 35 (ví dụ C:\\Users\\daova\\Desktop\\Log\\AppBlock\\ListAppBock.txt , trong ListAppBlock.txt có nội dung Notepad++.exe thì ứng dụng bị chặn ko cho mở là Notepad++)
    + Thực hiện kiểm tra các kết nối ngoại vi tới máy tính (Class ListDevice): với class nay bạn cần tạo Data base có bảng chuwa các thông tin gôm id, venderID, ProductID. config tuowng ự trong class HttpURLCrawData và ConnectDB
    
    
    -Phần 2 gom Server và Client và View ( có chức năng gửi tất cả các file log lên server , chú ý bạn cần cấu hình các file log ở trên ở cùng 1 folder và đường dẫn folder này sẽ sự dụng để thay thế vào các đường dẫn trong Class Client)
       

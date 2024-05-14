CÁC CÂU LỆNH GIT CƠ BẢN ĐỂ LÀM VIỆC VỚI CODE VÀ TRÁNH CONFLIX !
1. Thêm tất cả các thay đổi vào staged area:

git add .

2. Commit các thay đổi đã staged với một message:

git commit -m "nội dung commit"

3. Push các commit lên repository remote trên nhánh main:

git push origin main

4. Push các commit lên repository remote trên một nhánh cụ thể:

git push origin <tên nhánh>

5. Tạo và chuyển sang một nhánh mới:

git checkout -b <tên nhánh>

6. Liệt kê tất cả các nhánh cục bộ:

git branch

7. Kiểm tra trạng thái của thư mục làm việc:

git status

8. Lấy các thay đổi mới từ repository remote trên nhánh main:

git fetch origin main

9. Kéo các thay đổi mới từ repository remote trên nhánh main về và merge vào nhánh hiện tại:

git pull origin main

10. Khôi phục tất cả các thay đổi chưa staged về trạng thái trước khi staged:

git restore .

Xử lý Conflict:
Khi xảy ra conflict, bạn cần giải quyết bằng cách thủ công. Đầu tiên, mở các tập tin bị conflict và chỉnh sửa để giải quyết xung đột. Sau đó, thêm các tập tin đã chỉnh sửa vào staged area bằng git add và tiếp tục commit bằng git commit. Sau khi conflict đã được giải quyết, bạn có thể tiếp tục push hoặc thực hiện bất kỳ thao tác Git nào khác.

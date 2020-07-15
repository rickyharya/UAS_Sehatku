<?php
include('koneksi.php');
$sql = "SELECT * FROM rumahsakit";
$result = mysqli_query($con, $sql);
if(!$result){
	echo "error menampilkan" .mysql_error($con);
}
$data = [];
while ($row = mysqli_fetch_object($result)) {
	$data['rumahsakit'][] = $row;
}
if (isset($_GET['printed'])) {
	echo '<pre>';
	echo json_encode($data, JSON_PRETTY_PRINT);
	echo '</pre>';
}else{
	echo json_encode($data);
}
?>
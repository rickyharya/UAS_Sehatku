<?php
$host = 'localhost';
$user = 'ricky';
$password = 'rikiharya';
$db_name = 'sehatku';

$con = mysqli_connect($host, $user, $password, $db_name);
if (mysqli_connect_error())
{
    echo "gagal melakukan koneksi : " .mysqli_connect_error();
}
?>

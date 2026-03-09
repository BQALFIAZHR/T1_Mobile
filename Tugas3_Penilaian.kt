fun main() {

    println("Nama   : Baiq Alfia Zahira")
    println("Nim    : F1D02310042")
    println("Matkul : Mobile Programming")

    println("\n==== SISTEM PENILAIAN ====\n")

    //ketiga kode yang berawalan print, nilai nya kita ambil dari input user di terminal untuk input nama string kalo angka integer
    print("Masukkan Nama Mahasiswa: ")
    val nama = readLine() ?: ""

    print("Masukkan nilai UTS (0-100): ")
    val uts = readLine()!!.toInt()

    print("Masukkan nilai UAS (0-100): ")
    val uas = readLine()!!.toInt()

    print("Masukkan nilai Tugas (0-100): ")
    val tugas = readLine()!!.toInt()

   //ini digunakan untuk validasi nilai dalam retang 0-100 dalam bentuk integer
    if (uts !in 0..100 || uas !in 0..100 || tugas !in 0..100) {
        println("Nilai harus berada dalam rentang 0 - 100")
        return
    }

    //rumus yang digunakan untuk menghitung bobot nilai akhir sesuai dengan hint yang diberikan tugas 
    val nilaiAkhir = (uts * 0.3) + (uas * 0.4) + (tugas * 0.3)

    //ini kita konversi dari angka ke Abjad dengan ketentuan yang berbeda
    val nilaiHuruf = when (nilaiAkhir.toInt()) {
        in 85..100 -> "A"
        in 70..84 -> "B"
        in 60..69 -> "C"
        in 50..59 -> "D"
        else -> "E"
    }

    //ini kita konversi dari angka ke huruf juga tapi dalam bentuk kalimat sebenarnya hampir sama dengan diatas tinggal dirubah saja
    val keterangan = when (nilaiAkhir.toInt()) {
        in 85..100 -> "Sangat Baik"
        in 70..84 -> "Baik"
        in 60..69 -> "Cukup"
        in 50..59 -> "Kurang"
        else -> "Sangat Kurang"
    }

    //ini untuk nentuin apakah mahasiswa tersebut lulus dan tidaknya jika nilai akhir lebih besar atau sama dengan 60 lulus jika tidak maka tidak lulus
    val status = if (nilaiAkhir >= 60) "LULUS" else "TIDAK LULUS"

    //kemudian ini output dari hasil yang akan dimasukkan user mulai dari nama dan nilai uts dari input user tadi kemudian nanti 
    //dihitung dan diperlihatkan hasil akhir dengan format 1 angka dibelakang koma kemduia grade yang kita konversi tadi juga keterangan dan status
    println("\n==== HASIL PENILAIAN ====")
    println("Nama Mahasiswa : $nama")
    println("Nilai UTS      : $uts (Bobot 30%)")
    println("Nilai UAS      : $uas (Bobot 40%)")
    println("Nilai Tugas    : $tugas (Bobot 30%)")

    println("----------------------------")
    println("Nilai Akhir    : %.1f".format(nilaiAkhir))
    println("Grade          : $nilaiHuruf")
    println("Keterangan     : $keterangan")
    println("Status         : $status")


//ini kemudian akan mencetak kalimat menentukan lulus dan tidaknya
    println("\nSelamat! Anda dinyatakan $status.")
}
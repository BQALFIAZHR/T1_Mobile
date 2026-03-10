//ini kita buat data class sesuai ketentuan soal yang diberikan
data class NilaiMahasiswa(
    val nim: String,
    val nama: String,
    val mataKuliah: String,
    val nilai: Int
)

//ini  adalah fungsi biat nentuin gradenya berdasarkan nilai sama dengan kode di tugas sebelumnya kita konversi saja dari angka ke huruf
fun getGrade(nilai: Int): String {
    return when (nilai) {
        in 85..100 -> "A"
        in 70..84 -> "B"
        in 60..69 -> "C"
        in 50..59 -> "D"
        else -> "E"
    }
}

fun main() {

    //kemudian di sini kita membuat 10 list data sesuai intruksi ada nim nama matkul dan nilai
    val daftarMahasiswa = listOf(
        NilaiMahasiswa("  F1D02310048",   "Fadila Rahmania", "     Sismul              ",90),
        NilaiMahasiswa("  F1D02310042",   "Baiq Alfia", "          Web Lanjut          ",85),
        NilaiMahasiswa("  F1D02310008",   "Ifad", "                Big Data            ",81),
        NilaiMahasiswa("  F1D02310255",   "Arkara Scwol", "        Kecerdasan Buatan   ",66),
        NilaiMahasiswa("  F1D02310001",   "Khair", "               Sismul              ",90),
        NilaiMahasiswa("  F1D02310043",   "Nana", "                Jarkom              ",80),
        NilaiMahasiswa("  F1D02310123",   "Alma Zarifa", "         Probstat            ",56),
        NilaiMahasiswa("  F1D02310114",   "Izzat", "               KTI                 ",65),
        NilaiMahasiswa("  F1D02310144",   "Bayu", "                RPL                 ", 70),
        NilaiMahasiswa(" F1D02310052",   "Intan", "               E-bisnis            ",93)
    )

    //Disini kita buat tabel untuk tabel data nilai mahasiswa 
    println("===== DATA NILAI MAHASISWA =====\n")
    println("No    NIM          Nama                  MataKuliah            Nilai")

    //menampilkan semua data mahasiswa menggunakan forEachIndexed
    daftarMahasiswa.forEachIndexed { index, mhs ->
        println("${index + 1}.  ${mhs.nim}  ${mhs.nama}  ${mhs.mataKuliah}  ${mhs.nilai}")
    }

    
    //disini kita buat statistik dimana untuk menghitung  ketiga variabel dibawah sudah ada hintnya tinggal kita masukkan
    println("\n===== STATISTIK =====")

    val rataRata = daftarMahasiswa.map { it.nilai }.average()
    val tertinggi = daftarMahasiswa.maxByOrNull { it.nilai }
    val terendah = daftarMahasiswa.minByOrNull { it.nilai }
    
    //ini menampilkan hasil statistik
    println("Total Mahasiswa : ${daftarMahasiswa.size}")
    println("Rata-rata Nilai : $rataRata")
    println("Nilai Tertinggi : ${tertinggi?.nilai} (${tertinggi?.nama})")
    println("Nilai Terendah  : ${terendah?.nilai} (${terendah?.nama})")

    
    //ini  kita akan filter mahasiswa yang lulus
    println("\n===== MAHASISWA LULUS =====")
    //jika nilainya lebih dari sama dengan 70 maka bisa disebut lulus
    val lulus = daftarMahasiswa.filter { it.nilai >= 70 }

    //lalu disini kita tampilkan daftar mahasiswa yang lulus
    lulus.forEachIndexed { index, mhs ->
        println("${index + 1}. ${mhs.nama} - ${mhs.nilai} (${getGrade(mhs.nilai)})")
    }

   
    //ini  kita akan filter mahasiswa yang tidak lulus
    println("\n===== MAHASISWA TIDAK LULUS =====")

    //ini kebalikan dari yang diatas di filter yang dibawah 70 makan disebut tidak lulus
    val tidakLulus = daftarMahasiswa.filter { it.nilai < 70 }
    //kemudian ditampilkan
    tidakLulus.forEach {
        println(" ${it.nama} - ${it.nilai}")
    }

   
    //ini kita urut nilai mahasiswanya berdasarkan nilai terkecil dulu
    println("\n===== URUT NILAI DESCENDING =====")

    val desc = daftarMahasiswa.sortedByDescending { it.nilai }

    //menampikan hasil pengurutannya
    desc.forEach {
        println("${it.nama} - ${it.nilai}")
    }

    
    //ini kita kelompok berdasarkan grade menggunakan groupBy
    println("\n===== KELOMPOK BERDASARKAN GRADE =====")

    val kelompokGrade = daftarMahasiswa.groupBy { getGrade(it.nilai) }

    kelompokGrade.forEach { (grade, list) ->
        println("Grade $grade:")
        list.forEach {
            println("${it.nama} - ${it.nilai}")
        }
    }

  
    //ini untuk menghitung jumlah mahasiswa di setiap gradenya misal jumlah siswa di grade A berapa
    println("\n===== JUMLAH PER GRADE =====")

    kelompokGrade.forEach { (grade, list) ->
        println("Grade $grade : ${list.size} mahasiswa")
    }

   
    //ini untuk pencarian nama mahasiswa nanti user harus menginputkan nama ke terminal 
    print("\nMasukkan nama yang ingin dicari: ")
    val cari = readLine()!!.lowercase()

    //disini kita mencari mahasiswa yang namanya mengandung text yang dimasukkan user
    val hasilCari = daftarMahasiswa.filter {
        it.nama.lowercase().contains(cari)
    }
    //disini dicetak hasilnya
    println("\nHasil Pencarian:")

    //kalo misalnya ga ditemukan ada keluar pesan mahasiswa tidak ditemukan
    if (hasilCari.isEmpty()) {
        println("Mahasiswa tidak ditemukan")
    } else {
        hasilCari.forEach {
            println("${it.nama} - ${it.nilai}")
        }
    }
}
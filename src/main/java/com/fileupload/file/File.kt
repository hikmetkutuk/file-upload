package com.fileupload.file

import javax.persistence.*

@Entity
@Table(name = "files")
data class File
(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long? = null,
    val name: String,
    val type: String,
    @Lob
    val data: ByteArray
)
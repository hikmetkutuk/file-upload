package com.fileupload.file

data class FileDto
(
    val name: String,
    val url: String,
    val type: String,
    val size: Long
)
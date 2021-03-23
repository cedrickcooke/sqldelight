package com.squareup.sqldelight.core

import com.alecstrong.sql.psi.core.DialectPreset
import java.io.File
import java.io.Serializable

data class SqlDelightPropertiesFileImpl(
  override val databases: List<SqlDelightDatabasePropertiesImpl>
) : SqlDelightPropertiesFile

data class SqlDelightDatabasePropertiesImpl(
  override val packageName: String,
  override val compilationUnits: List<SqlDelightCompilationUnitImpl>,
  override val className: String,
  override val dependencies: List<SqlDelightDatabaseNameImpl>,
  override val dialectPresetName: String = DialectPreset.SQLITE_3_18.name,
  override val deriveSchemaFromMigrations: Boolean = false,
  override val outputDirectoryFile: File,
  override val rootDirectory: File,
  override val visibilities: SqlDelightVisibilities
) : SqlDelightDatabaseProperties

data class SqlDelightDatabaseNameImpl(
  override val packageName: String,
  override val className: String
) : SqlDelightDatabaseName

data class SqlDelightCompilationUnitImpl(
  override val name: String,
  override val sourceFolders: List<SqlDelightSourceFolderImpl>
) : SqlDelightCompilationUnit

data class SqlDelightSourceFolderImpl(
  override val folder: File,
  override val dependency: Boolean = false
) : SqlDelightSourceFolder

data class SqlDelightVisibilitiesImpl(
  override val api: SqlDelightVisibility = SqlDelightVisibility.PUBLIC,
  override val impl: SqlDelightVisibility = SqlDelightVisibility.PUBLIC,
  override val models: SqlDelightVisibility = SqlDelightVisibility.PUBLIC
) : SqlDelightVisibilities

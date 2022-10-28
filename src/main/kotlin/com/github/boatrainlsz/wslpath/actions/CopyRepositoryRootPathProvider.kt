package com.github.boatrainlsz.wslpath.actions

import com.intellij.ide.actions.DumbAwareCopyPathProvider
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.project.Project
import com.intellij.openapi.vcs.ProjectLevelVcsManager
import com.intellij.openapi.vfs.VfsUtilCore
import com.intellij.openapi.vfs.VirtualFile

class CopyPathInWSLProvider : DumbAwareCopyPathProvider() {
  override fun getPathToElement(project: Project, virtualFile: VirtualFile?, editor: Editor?): String? {
    if (virtualFile == null) return null

    val vcsRoot = ProjectLevelVcsManager.getInstance(project).getVcsRootObjectFor(virtualFile)
    if (vcsRoot == null) return null

    return VfsUtilCore.getRelativePath(virtualFile, vcsRoot.path)
  }
}
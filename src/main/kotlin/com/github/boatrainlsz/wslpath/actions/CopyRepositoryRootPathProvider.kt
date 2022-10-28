package com.github.boatrainlsz.wslpath.actions

import com.intellij.ide.actions.DumbAwareCopyPathProvider
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile

class CopyPathInWSLProvider : DumbAwareCopyPathProvider() {
    override fun getPathToElement(project: Project, virtualFile: VirtualFile?, editor: Editor?): String? {
        if (virtualFile == null) return null
        val presentableUrl = virtualFile.presentableUrl
        //presentableUrl is like: D:\research\wslpath\filename.txt
        //we want to convert it to /mnt/d/research/wslpath/filename.txt, D is upper case, need to convert to lower case
        val path = presentableUrl.substring(0, 2).lowercase() + presentableUrl.substring(2)
        return "/mnt/" + path.replace("\\", "/").replace(":", "")
    }
}
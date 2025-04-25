package com.example.ak_34_al_38

class Tree(val root: TreeNode) // Opcional: Clase contenedora para el árbol

open class TreeNode(val name: String) {
    val children = mutableListOf<TreeNode>()

    fun menu(caption: String, init: TreeNode.() -> Unit) {
        val newMenu = TreeNode(caption)
        newMenu.init()
        children.add(newMenu)
    }

    fun menuItem(caption: String, init: TreeNode.() -> Unit = {}) {
        val newMenuItem = TreeNode(caption)
        newMenuItem.init()
        children.add(newMenuItem)
    }

    override fun toString(): String {
        return "TreeNode(name='$name', children=${children.map { it.name }})"
    }
}

fun treeBar(init: TreeNode.() -> Unit): Tree { // Análogo a JFrame.menuBar
    val root = TreeNode("Root") // Podrías cambiar "Root" por algo más genérico si es necesario
    root.init()
    return Tree(root)
}

fun main() {
    val myTree = treeBar {
        menu("Menu1") {
            menuItem("Item1") {
                // Inicialización específica del item si es necesario
            }
            menuItem("Item2") {}
        }
        menu("Menu2") {
            menuItem("Item3") {}
            menuItem("Item4") {}
        }
    }
    println(myTree.root)
}
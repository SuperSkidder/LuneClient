package librarys.org.objectweb.asm.tree;

import java.util.List;
import librarys.org.objectweb.asm.ModuleVisitor;

public class ModuleOpenNode {
  public String packaze;
  
  public int access;
  
  public List<String> modules;
  
  public ModuleOpenNode(String packaze, int access, List<String> modules) {
    this.packaze = packaze;
    this.access = access;
    this.modules = modules;
  }
  
  public void accept(ModuleVisitor moduleVisitor) { moduleVisitor.visitOpen(this.packaze, this.access, (this.modules == null) ? null : (String[])this.modules
        .toArray(new String[0])); }
}

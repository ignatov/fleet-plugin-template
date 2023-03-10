package fleet.sample.frontend

import com.jetbrains.rhizomedb.Entrypoint
import fleet.frontend.actions.ActionsEP
import fleet.frontend.actions.windowManager
import fleet.kernel.ChangeScope
import fleet.kernel.register
import noria.model.Action
import noria.model.ActionPresentation
import noria.model.Propagate
import noria.model.Trigger
import noria.windowManagement.extensions.openUrl

@Entrypoint
fun ChangeScope.entrypoint() {
    register {
        ActionsEP.register {
            Action(
                defaultPresentation = ActionPresentation("Open Fleet Website"),
                perform = { ac ->
                    ac.windowManager.openUrl("https://jetbrains.com/fleet")
                    Propagate.STOP
                },
                triggers = setOf(trigger),
                identifier = Action.Identifier(trigger.ident),
            )
        }
    }
}

val trigger = Trigger("open-fleet-website")